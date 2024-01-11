package com.mercadolibre.cardealership.dto;

import java.util.List;

public record VehicleDTO(
        String brand,
        String model,
        String manufacturingDate,
        String numberOfKilometers,
        String doors,
        String price,
        String currency,
        List<ServicesDTO> services,
        String countOfOwners
) {
}
