package org.movies.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "genres")
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "ranking")
    private Long ranking;

    @Column(name = "active")
    private Boolean active;
}
