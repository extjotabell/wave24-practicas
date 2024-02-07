package com.practice.jewerly.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record JewelDto(
        @JsonProperty("nro_identificatorio")
        Long nroIdentificatorio,
        String nombre,
        String material,
        Double peso,
        String particularidad,
        @JsonProperty("posee_piedra")
        Boolean poseePiedra,
        Boolean ventaONo
) {
}
