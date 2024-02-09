package com.jpa.integrador.entity;

import com.jpa.integrador.dto.request.ClothRequestDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;

import java.util.Set;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Entity
@Table(name = "prenda")
public class Cloth {
    @Id
    @GeneratedValue
    private Integer id;
    @Column(name = "nombre")
    private String name;
    @Column(name = "marca")
    private String brand;
    @Column(name = "color")
    private String color;
    @Column(name = "talle")
    private String size;
    @Column(name = "cantidad")
    private Integer quantity;
    @Column(name = "precio_venta")
    private Double salePrice;

    @ManyToMany(mappedBy = "clothes")
    private Set<Sale> sales;

    public Cloth(ClothRequestDTO clothRequestDTO){
        this.id = clothRequestDTO.id();
        this.name = clothRequestDTO.name();
        this.brand = clothRequestDTO.brand();
        this.color = clothRequestDTO.color();
        this.size = clothRequestDTO.size();
        this.quantity = clothRequestDTO.quantity();
        this.salePrice = clothRequestDTO.salePrice();
    }

}
