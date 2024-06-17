package com.InfoSpot.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity

@Getter
@Setter
@Table(name="actor")
public class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "actor_id_generator")
    @SequenceGenerator(name = "actor_id_generator", sequenceName = "actor_actor_id_seq", allocationSize = 1)
    @Column(name = "actor_id")
    private int actorId;

    @Column(name="first_name", nullable = false)

    private String firstName;

    @Column(name="last_name", nullable = false)
    private String lastName;


    @ManyToMany(mappedBy = "actors")
    private Set<Film> films = new HashSet<>();


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
