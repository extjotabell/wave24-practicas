package org.jewerly.lasperlas.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.function.DoubleBinaryOperator;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "jewerly")
public class Jewerly {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "identification_number")
    private Long identificationNumber;
    private String name;
    private String material;
    private Double weight;
    private String particularity;
    @Column(name = "has_stone")
    private Boolean hasStone;
    @Column(name = "is_on_sale")
    private Boolean isOnSale;

}
