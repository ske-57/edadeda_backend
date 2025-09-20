package com.example.edadeda_backend.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "items")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 64,nullable = false)
    @Getter
    @Setter
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    @Getter @Setter
    private String description;

    @Column(nullable = false)
    @Getter @Setter
    private Long price;

    @Column(length = 128)
    @Getter @Setter
    private String location;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 32)
    @Getter @Setter
    private EnumItemStatus status = EnumItemStatus.AVAILABLE;

    @Column(name = "auto_report_link", length = 256)
    @Getter @Setter
    private String autoReportLink;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "seller_id", nullable = false)
    @Getter @Setter
    private User seller;


    public Long getId() {
        return id;
    }
}
