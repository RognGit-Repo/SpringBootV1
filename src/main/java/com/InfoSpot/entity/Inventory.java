package com.InfoSpot.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
    @Table(name = "inventory")
    public class Inventory {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "inventory_id")
        private int inventoryId;

        @ManyToOne
        @JoinColumn(name = "film_id")
        private Film film;

        @ManyToOne
        @JoinColumn(name = "store_id")
        private Store store;

    @Column(name = "last_modified")
    private LocalDateTime lastModified;

    // Constructors, getters, setters

    @PrePersist
    protected void onCreate() {
        lastModified = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        lastModified = LocalDateTime.now();
    }

        // Constructors, getters, and setters
    }

