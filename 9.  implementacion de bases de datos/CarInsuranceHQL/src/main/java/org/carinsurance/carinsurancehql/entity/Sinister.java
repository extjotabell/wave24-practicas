package org.carinsurance.carinsurancehql.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "sinister")
public class Sinister {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "date_sinister")
    private LocalDate dateSinister;
    @Column(name = "economic_loss")
    private Double economicLoss;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Vehicle vehicle;

}
