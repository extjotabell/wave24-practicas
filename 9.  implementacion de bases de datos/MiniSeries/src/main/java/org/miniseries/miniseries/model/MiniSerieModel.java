package org.miniseries.miniseries.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "mini_series")
public class MiniSerieModel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private Double rating;
    @Column(name = "amount_of_awards")
    private int amountOfAwards;
}
