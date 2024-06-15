package com.InfoSpot.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "payment")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_id")
    private int paymentId;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "rental_id")
    private Rental rental;

    @Column(name = "amount")
    private double amount;

    @Column(name = "payment_date")
    private Date paymentDate;

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
