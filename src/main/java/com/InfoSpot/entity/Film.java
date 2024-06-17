package com.InfoSpot.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Setter
@Getter
@Table(name="film")
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "film_id_generator")
    @SequenceGenerator(name = "film_id_generator", sequenceName = "film_film_id_seq", allocationSize = 1)
    @Column(name = "film_id")
    private int filmId;

    @Column(name="title", nullable = false)
    private String title;

    @Column(name="description")
    private String description;

    @Column(name="release_year")
    private int releaseYear;

    @Column(name="rental_duration", nullable = false)
    private int rentalDuration;

    @ManyToOne
    @JoinColumn(name = "language_id", nullable = false)
    private Language language;

    @Column(name="rental_rate", nullable = false)
    private double rentalRate;

    @Column(name="length")
    private int length;

    @Column(name="replacement_cost", nullable = false)
    private double replacementCost;

    @Column(name="rating")
    private String rating;

    @Column(name = "special_features", columnDefinition = "text[]")
    private String[] specialFeatures;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "film_actor",
            joinColumns = @JoinColumn(name = "film_id"),
            inverseJoinColumns = @JoinColumn(name = "actor_id"))
    private Set<Actor> actors = new HashSet<>();

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "film_category",
            joinColumns = @JoinColumn(name = "film_id"),
            inverseJoinColumns = @JoinColumn(name = "actor_category"))
    private Set<Category> categories = new HashSet<>();

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
}
