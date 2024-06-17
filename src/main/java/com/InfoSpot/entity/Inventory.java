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
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "inventory_id_generator")
        @SequenceGenerator(name = "inventory_id_generator", sequenceName = "inventory_inventory_id_seq", allocationSize = 1)
        @Column(name = "inventory_id")
        private int inventoryId;

        @ManyToOne
        @JoinColumn(name = "film_id", nullable = false)
        private Film film;

        @ManyToOne
        @JoinColumn(name = "store_id", nullable = false)
        private Store store;

    @Column(name = "last_modified", nullable = false)
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

