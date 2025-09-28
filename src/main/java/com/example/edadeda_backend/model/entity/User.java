package com.example.edadeda_backend.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "users")
public class User {

    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tg_id", nullable = false, unique = true)
    @Getter @Setter
    private Long tgId;

    @Column(nullable = false, length = 64)
    @Getter @Setter
    private String name;

    @Column(name = "is_seller")
    @Getter @Setter
    private Boolean isSeller = false;
}
