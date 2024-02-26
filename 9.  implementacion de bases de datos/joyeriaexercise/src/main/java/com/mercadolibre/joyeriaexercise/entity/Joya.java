package com.mercadolibre.joyeriaexercise.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Entity
@Table(name = "Joya")
public class Joya {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long nroIdentificatorio;

    @Column(name = "nombre", length = 200)
    private String nombre;

    @Column(name = "material")
    private String material;

    @Column(name = "peso")
    private Double peso;

    @Column(name = "particularidad")
    private String particularidad;

    @Column(name = "posee_piedra")
    private Boolean poseePiedra;

    @Column(name = "ventaONo")
    private Boolean ventaONo;
}
