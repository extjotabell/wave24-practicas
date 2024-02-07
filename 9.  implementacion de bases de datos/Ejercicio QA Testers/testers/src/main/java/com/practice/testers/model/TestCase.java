package com.practice.testers.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class TestCase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCase;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private Boolean tested;
    @Column(nullable = false)
    private Boolean passed;
    @Column(nullable = false)
    private int numberOfTries;
    @Column(nullable = false)
    private LocalDate lastUpdate;
}
