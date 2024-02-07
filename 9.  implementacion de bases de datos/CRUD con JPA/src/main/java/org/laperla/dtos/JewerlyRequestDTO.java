package org.laperla.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public record JewerlyRequestDTO (
        @JsonProperty("name")
        String name,
        @JsonProperty("material")
        String material,
        @JsonProperty("weight")
        Double weight,
        @JsonProperty("particularity")
        String particularity,
        @JsonProperty("has_stone")
        Boolean hasStone
) {
}
