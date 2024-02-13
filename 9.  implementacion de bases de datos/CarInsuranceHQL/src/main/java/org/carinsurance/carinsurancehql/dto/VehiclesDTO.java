package org.carinsurance.carinsurancehql.dto;

public record VehiclesDTO(
        Long id,
        String patent,
        String brand,
        String model,
        String fabricationYear,
        Integer quantityWheels
) {
}
