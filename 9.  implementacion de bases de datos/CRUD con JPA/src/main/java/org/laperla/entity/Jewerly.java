package org.laperla.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "jewerly")
public class Jewerly {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nro_identificatorio")
    private Long id;

    @Column(name = "nombre")
    private String name;

    @Column(name = "material")
    private String material;

    @Column(name = "peso")
    private Double weight;

    @Column(name = "particularidad")
    private String particularity;

    @Column(name = "posee_piedra")
    private Boolean hasStone;

    @Column(name = "ventaONo")
    private Boolean isOnSale;



}
