package com.JPA.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

// INDICAR QUE ESTO ES UNA ENTIDAD Y UNA TABLA
@Entity
// INDICA LAS CONFIGURACIONES DE LA TABLA
@Table(name = "Producto")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre", length = 20)
    private String name;

    @Column(name = "descripcion", length = 255)
    private String description;
}
