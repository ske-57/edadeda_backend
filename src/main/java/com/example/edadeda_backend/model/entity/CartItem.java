package com.example.edadeda_backend.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "cart_items")
@Getter
@Setter
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "cart_id", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Cart cart;

    @JoinColumn(name = "item_id", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Item item;

    @Column(nullable = false)
    private Integer qty = 1;

    @Column(name = "total_price", nullable = false)
    private Long totalPrice;
}
