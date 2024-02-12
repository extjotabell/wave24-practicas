package org.example.hqlvehiculosasegurados.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.example.hqlvehiculosasegurados.entity.Siniestro;

import java.util.List;

public record VehiculoDto(
        Long id,
        String patente,
        String marca,
        String modelo,

        @JsonProperty("anio_fabricacion")
        Integer anioFabricacion,
        @JsonProperty("cantidad_de_ruedas")
        Integer cantidadDeRuedas
) {
}
