package org.example.hqlvehiculosasegurados.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.example.hqlvehiculosasegurados.entity.Vehiculo;

import java.time.LocalDate;

public record SiniestroDto(
        Long id,
        @JsonProperty("fecha_siniestro")
        LocalDate fechaSiniestro,
        @JsonProperty("perdida_economica")
        Double perdidaEconomica,

        @JsonProperty("id_vehiculo")
        Long idVehiculo
) {
}
