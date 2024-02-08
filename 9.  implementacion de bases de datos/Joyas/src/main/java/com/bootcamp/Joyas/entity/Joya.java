package com.bootcamp.Joyas.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Joya {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nro_identificatorio")
    private Long id;

    private String nombre;

    private String material;

    private Float gramos;

    private String particularidad;

    @Column(name = "posee_piedra")
    private Boolean poseePiedra;

    @Column(name = "venta_o_no")
    private Boolean ventaONo;


    public Joya(String nombre, String material, Float gramos, String particularidad, Boolean posee_piedra, Boolean ventaONo) {
        this.nombre = nombre;
        this.material = material;
        this.gramos = gramos;
        this.particularidad = particularidad;
        this.poseePiedra = posee_piedra;
        this.ventaONo = ventaONo;
    }
}
