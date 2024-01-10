package org.meli.co.covid19.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;


@AllArgsConstructor
public class PacienteDTO implements Serializable {

    private String nombre;

    private String apellido;

    private Integer edad;

    private List<Sintoma> sintomas;



}
