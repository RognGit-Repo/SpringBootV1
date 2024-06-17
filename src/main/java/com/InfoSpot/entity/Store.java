package com.InfoSpot.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "store")
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "store_id_generator")
    @SequenceGenerator(name = "store_id_generator", sequenceName = "store_store_id_seq", allocationSize = 1)
    @Column(name = "store_id")
    private int storeId;

    @ManyToOne
    @JoinColumn(name = "manager_staff_id" , nullable = false)
    private Staff manager;

    @ManyToOne
    @JoinColumn(name = "address_id", nullable = false)
    private Address address;

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