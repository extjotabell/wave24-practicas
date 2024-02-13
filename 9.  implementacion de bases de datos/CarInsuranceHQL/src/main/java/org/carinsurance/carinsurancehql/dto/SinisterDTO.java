package org.carinsurance.carinsurancehql.dto;

import org.carinsurance.carinsurancehql.dto.VehiclesDTO;

import java.time.LocalDate;

public record SinisterDTO(
    Long id,
    LocalDate dateSinister,
    Double economicLoss,
    VehiclesDTO vehicle
) {
}
