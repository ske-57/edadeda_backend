package com.example.edadeda_backend.repository;
import com.example.edadeda_backend.model.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    @Query(
            value = "SELECT " +
                    "i.id, i.title, i.description, i.price, " +
                    "i.location, i.status, i.auto_report_link, " +
                    "i.seller_id, i.image_path " +
                    "FROM items i JOIN cart_items ci ON ci.item_id = i.id AND ci.cart_id = ?1",
            nativeQuery = true
    )
    List<Item> getAllItemsByCartId(Long cartId);
}
