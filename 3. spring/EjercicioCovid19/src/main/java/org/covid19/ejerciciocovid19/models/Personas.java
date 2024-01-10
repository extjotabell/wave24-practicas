package org.covid19.ejerciciocovid19.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class Personas {

    private Integer id;
    private String nombres;
    private String apellidos;
    private Integer edad;
}
