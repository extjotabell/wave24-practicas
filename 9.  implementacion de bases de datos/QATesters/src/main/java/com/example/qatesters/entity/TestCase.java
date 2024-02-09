package com.example.qatesters.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

@Entity
@Table(name = "testCase")
public class TestCase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_case;

    @Column(name = "description")
    private String description;

    @Column(name = "tested")
    private Boolean tested;

    @Column(name = "passed")
    private Boolean passed;

    @Column(name = "number_of_tries")
    private int number_of_tries;

    @Column(name = "lastUpdate")
    private LocalDate lastUpdate;

}
