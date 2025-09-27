package com.example.edadeda_backend.service.cartItem;

import com.example.edadeda_backend.exception.NotFoundException;
import com.example.edadeda_backend.model.dto.cartItem.CartItemCreateRequest;
import com.example.edadeda_backend.model.dto.cartItem.CartItemResponse;
import com.example.edadeda_backend.model.entity.Cart;
import com.example.edadeda_backend.model.entity.CartItem;
import com.example.edadeda_backend.model.entity.Item;
import com.example.edadeda_backend.repository.CartItemRepository;
import com.example.edadeda_backend.repository.CartRepository;
import com.example.edadeda_backend.repository.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartItemServiceImpl implements CartItemService {
    private final CartItemRepository cartItemRepository;
    private final CartRepository cartRepository;
    private final ItemRepository itemRepository;

    public CartItemServiceImpl(CartItemRepository cartItemRepository,
                               CartRepository cartRepository, ItemRepository itemRepository) {
        this.cartItemRepository = cartItemRepository;
        this.cartRepository = cartRepository;
        this.itemRepository = itemRepository;
    }

    private CartItemResponse toResponse(CartItem cartItem) {
        CartItemResponse cartItemResponse = new CartItemResponse();
        cartItemResponse.setId(cartItem.getId());
        cartItemResponse.setCartId(cartItem.getCart().getId());
        cartItemResponse.setItemId(cartItem.getItem().getId());
        cartItemResponse.setQty(cartItem.getQty());
        cartItemResponse.setTotalPrice(cartItem.getTotalPrice());
        return cartItemResponse;
    }

    @Override
    public CartItemResponse createCartItem(CartItemCreateRequest req) {
        Cart cart = cartRepository.findById(req.getCartId())
                .orElseThrow(() -> new NotFoundException("Cart for adding item not found"));
        Item item = itemRepository.findById(req.getItemId())
                .orElseThrow(() -> new NotFoundException("Item for adding not found"));

        CartItem cartItem = new CartItem();
        cartItem.setCart(cart);
        cartItem.setQty(req.getQty());
        cartItem.setTotalPrice(req.getTotalPrice());
        cartItem.setItem(item);

        return toResponse(cartItemRepository.save(cartItem));
    }

    @Override
    public List<CartItemResponse> getAllByCartId(Long cartId) {
        return cartItemRepository.getAllItemsByCartId(cartId)
                .stream()
                .map(this::toResponse)
                .toList();
    }
}
