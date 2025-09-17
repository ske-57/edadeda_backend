package com.example.edadeda_backend.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "cart")
public class Cart {

    @Id
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

    @Getter @Setter
    private Integer quantity = 1;

    @Column(name = "created_at")
    @Getter
    private LocalDateTime createdAt = LocalDateTime.now();

    public Long getId() {
        return id;
    }
}
