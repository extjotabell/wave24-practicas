package org.carinsurance.carinsurancehql.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

public record SummaryVehiclesDTO(
        String patent,
        @JsonInclude(JsonInclude.Include.NON_NULL) String brand,
        @JsonInclude(JsonInclude.Include.NON_NULL) String model
) {
    public SummaryVehiclesDTO(String patent, String brand, String model) {
        this.patent = patent;
        this.brand = brand;
        this.model = model;
    }

    public SummaryVehiclesDTO(String patent, String brand) {
        this(patent, brand, null);
    }

    public SummaryVehiclesDTO(String patent) {
        this(patent, null, null);
    }
}
