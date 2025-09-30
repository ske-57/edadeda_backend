package com.example.edadeda_backend.service.cart;

import com.example.edadeda_backend.exception.NotFoundException;
import com.example.edadeda_backend.model.dto.cart.CartCreateRequest;
import com.example.edadeda_backend.model.dto.cart.CartResponse;
import com.example.edadeda_backend.model.dto.cartItem.CartItemCreateRequest;
import com.example.edadeda_backend.model.dto.cartItem.CartItemResponse;
import com.example.edadeda_backend.model.dto.item.ItemResponse;
import com.example.edadeda_backend.model.entity.Cart;
import com.example.edadeda_backend.model.entity.CartItem;
import com.example.edadeda_backend.model.entity.Item;
import com.example.edadeda_backend.model.entity.User;
import com.example.edadeda_backend.repository.CartItemRepository;
import com.example.edadeda_backend.repository.CartRepository;
import com.example.edadeda_backend.repository.ItemRepository;
import com.example.edadeda_backend.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;
    private final UserRepository userRepository;
    private final ItemRepository itemRepository;
    private final CartItemRepository cartItemRepository;

    public CartServiceImpl(CartRepository cartRepository, UserRepository userRepository, ItemRepository itemRepository, CartItemRepository cartItemRepository) {
        this.cartRepository = cartRepository;
        this.userRepository = userRepository;
        this.itemRepository = itemRepository;
        this.cartItemRepository = cartItemRepository;
    }

    @Override
    public CartResponse createCart(CartCreateRequest req) {
        User user = userRepository.findById(req.getUserId())
                .orElseThrow(() -> new NotFoundException("User for creating cart not found"));

        Cart cartToSave = new Cart();
        cartToSave.setUser(user);
        return cartToResponse(cartRepository.save(cartToSave));
    }

    @Override
    public List<CartResponse> getAllCarts() {
        return cartRepository.findAll()
                .stream()
                .map(this::cartToResponse)
                .toList();
    }

    @Override
    public CartResponse getCartByUserId(Long userId) {
        User user =  userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException("User not existed"));

        return cartToResponse(cartRepository.getCartByUserId(userId));
    }

    @Override
    public List<ItemResponse> getAllItemsByCartId(Long cartId) {
        return itemRepository.getAllItemsByCartId(cartId)
                .stream()
                .map(this::itemToResponse)
                .toList();
    }

    @Override
    public CartItemResponse createCartItem(Long cartId, CartItemCreateRequest req) {
        Cart cart = cartRepository.findById(cartId)
                .orElseThrow(() -> new NotFoundException("Cart for adding item not found"));
        Item item = itemRepository.findById(req.getItemId())
                .orElseThrow(() -> new NotFoundException("Item for adding not found"));

        CartItem cartItem = new CartItem();
        cartItem.setCart(cart);
        cartItem.setQty(req.getQty());
        cartItem.setTotalPrice(req.getTotalPrice());
        cartItem.setItem(item);

        return cartItemToResponse(cartItemRepository.save(cartItem));
    }

    @Override
    public void deleteCartById(Long cartId) {
        if (userRepository.findById(cartId).isPresent()) {
            cartRepository.deleteById(cartId);
        } else  {
            throw new NotFoundException("Cart for delete not found");
        }
    }

    private CartResponse cartToResponse(Cart cart) {
        return new CartResponse(cart.getId(),
                cart.getUser().getId());
    }

    private CartItemResponse cartItemToResponse(CartItem cartItem) {
        CartItemResponse cartItemResponse = new CartItemResponse();
        cartItemResponse.setId(cartItem.getId());
        cartItemResponse.setCartId(cartItem.getCart().getId());
        cartItemResponse.setItemId(cartItem.getItem().getId());
        cartItemResponse.setQty(cartItem.getQty());
        cartItemResponse.setTotalPrice(cartItem.getTotalPrice());
        return cartItemResponse;
    }

    private ItemResponse itemToResponse(Item i) {
        return new ItemResponse(i.getId(), i.getTitle(), i.getDescription(),
                i.getPrice(), i.getLocation(),
                i.getStatus(), i.getAutoReportLink(),
                i.getSeller().getId());
    }
}
