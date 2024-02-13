package org.example.clavecompuesta.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
@Entity
@Table(name = "compras")
@IdClass(value = CompraKey.class)
public class Compra {

    @Id
    private Long id;

    @Id
    private LocalDate fecha;
}
