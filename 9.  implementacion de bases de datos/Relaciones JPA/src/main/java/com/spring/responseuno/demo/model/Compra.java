package com.spring.responseuno.demo.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.time.LocalDate;

@Entity
@Data
@IdClass(CompraKey.class)
public class Compra {
    @Id
    private int clienteId;

    @Id
    private String fecha;

    private int productoId;
    private int cantidad;
    private double precio;

}
