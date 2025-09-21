package com.example.edadeda_backend.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "cart")
public class Cart {

    @Id
    @Getter @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne()
    @JoinColumn(name = "user_id", nullable = false)
    @Getter @Setter
    private User user;

    @ManyToOne()
    @JoinColumn(name = "item_id", nullable = false)
    @Getter @Setter
    private Item item;

    @Column(name = "created_at")
    @Getter
    private LocalDateTime createdAt = LocalDateTime.now();
}
