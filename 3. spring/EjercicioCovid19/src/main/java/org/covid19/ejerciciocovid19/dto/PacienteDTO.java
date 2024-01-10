package org.covid19.ejerciciocovid19.dto;

import org.covid19.ejerciciocovid19.models.Sintomas;

import java.util.List;

public record PacienteDTO(String nombre, String apellidos, Integer edad, List<Sintomas> sintomas) {
}
