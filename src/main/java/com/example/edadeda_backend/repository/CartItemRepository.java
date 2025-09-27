package com.example.edadeda_backend.repository;

import com.example.edadeda_backend.model.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    List<CartItem> getAllItemsByCartId(Long cartId);
    @Query(
            value = "DELETE FROM cart_items ci WHERE ci.cart_id = ?1 AND ci.item_id = ?2",
            nativeQuery = true
    )
    void deleteCartItemByCartId(Long cartId, Long cartItemId);
}
