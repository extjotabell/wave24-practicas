package com.spring.responseuno.demo.model;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
public class CompraKey implements Serializable {

    private int clienteId;
    private String fecha;

}
