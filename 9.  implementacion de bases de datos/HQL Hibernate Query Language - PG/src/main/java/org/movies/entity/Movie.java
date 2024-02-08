package org.movies.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
@Table(name = "movies")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "rating")
    private Double rating;

    @Column(name = "awards")
    private Long awards;

    @Column(name = "release_date")
    private LocalDate releaseDate;

    @Column(name = "length")
    private Long length;


    @Column(name = "created_at")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate createdAt;

    @Column(name = "updated_at")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate updatedAt;

    @ManyToOne
    @JoinColumn(name = "genre_id")
    private Genre genre;
}
