package com.example.edadeda_backend.service.cart;

import com.example.edadeda_backend.exception.NotFoundException;
import com.example.edadeda_backend.model.dto.cart.CartCreateRequest;
import com.example.edadeda_backend.model.dto.cart.CartResponse;
import com.example.edadeda_backend.model.dto.cart.CartUpdateRequest;
import com.example.edadeda_backend.model.entity.Cart;
import com.example.edadeda_backend.model.entity.Item;
import com.example.edadeda_backend.model.entity.User;
import com.example.edadeda_backend.repository.CartRepository;
import com.example.edadeda_backend.repository.ItemRepository;
import com.example.edadeda_backend.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;
    private final ItemRepository itemRepository;
    private final UserRepository userRepository;

    public CartServiceImpl(CartRepository cartRepository, ItemRepository itemRepository, UserRepository userRepository) {
        this.cartRepository = cartRepository;
        this.itemRepository = itemRepository;
        this.userRepository = userRepository;
    }

    private CartResponse toResponse(Cart cart) {
        return new CartResponse(cart.getId(),
                cart.getUser().getId(),
                cart.getItem().getId(),
                cart.getCreatedAt());
    }

    @Override
    public CartResponse createCart(CartCreateRequest req) {
        User user = userRepository.findById(req.getUserId())
                .orElseThrow(() -> new NotFoundException("User for creating cart not found"));

        Item item = itemRepository.findById(req.getItemId())
                .orElseThrow(() -> new NotFoundException("Item for creating cart not found"));

        Cart cartToSave = new Cart();
        cartToSave.setId(user.getId());
        cartToSave.setItem(item);
        cartToSave.setUser(user);
        return toResponse(cartRepository.save(cartToSave));
    }

    @Override
    public CartResponse findById(Long id) {
        return toResponse(cartRepository.findById(id).orElseThrow(() -> new NotFoundException("Cart not found")));
    }

    @Override
    public List<CartResponse> getAllCarts() {
        return cartRepository.findAll()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    @Override
    public CartResponse updateCart(Long id, CartUpdateRequest req) {
        Cart cartToUpdate = cartRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Cart for update not found"));
        Item item = itemRepository.findById(req.getItemId())
                .orElseThrow(() -> new NotFoundException("Item for update cart not found"));

        if (req.getUserId() != null) {cartToUpdate.setItem(item);}

        return toResponse(cartRepository.save(cartToUpdate));
    }

    @Override
    public void deleteCartById(Long cartId) {
        if (userRepository.findById(cartId).isPresent()) {
            cartRepository.deleteById(cartId);
        } else  {
            throw new NotFoundException("Cart for delete not found");
        }
    }
}
