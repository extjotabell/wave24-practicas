package com.JoyeriaLasPerlas.JoyeriaLasPerlas.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

@Entity
@Table(name = "Joya")
public class Joya {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer nro_identificatorio;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "material")
    private String material;

    @Column(name = "peso")
    private Double peso;

    @Column(name = "particularidad")
    private String particularidad;

    @Column(name = "poseePiedra")
    private Boolean posee_piedra;

    @Column(name = "ventaONo")
    private Boolean ventaONo;

}
