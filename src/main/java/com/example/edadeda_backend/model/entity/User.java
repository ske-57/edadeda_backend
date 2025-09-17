package com.example.edadeda_backend.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "users")
public class User {

    @Getter @Setter
    @Id
    private Long id;

    @Setter
    @Getter
    @Column(nullable = false, length = 64)
    private String name;

    @Column(name = "is_seller")
    @Getter @Setter
    private Boolean isSeller = false;
}
