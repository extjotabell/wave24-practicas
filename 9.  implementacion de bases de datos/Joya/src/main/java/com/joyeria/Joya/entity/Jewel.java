package com.joyeria.Joya.entity;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Entity
@Table(name = "joya")
public class Jewel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", length = 20, nullable = false)
    private String name;

    @Column(name = "material", length = 20, nullable = false)
    private String material;

    @Column(name = "peso", nullable = false)
    private double weight;

    @Column(name = "particularidad", length = 100, nullable = false)
    private String particularity;

    @Column(name = "posee_piedra")
    private Boolean hasGemstone;

    @Column(name = "venta_o_no", nullable = false)
    private Boolean isForSale;
}
