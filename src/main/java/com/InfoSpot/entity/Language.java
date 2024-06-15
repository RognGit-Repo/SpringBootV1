package com.InfoSpot.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "language")
public class Language {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "language_id")
    private int languageId;

    @Column(name = "name")
    private String name;

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