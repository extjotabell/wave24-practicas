package com.joyeria.Joya.dto;

public record JewelDTO(
        Long id,
        String name,
        String material,
        Double weight,
        String particularity,
        Boolean hasGemstone,
        Boolean isForSale
) {
}
