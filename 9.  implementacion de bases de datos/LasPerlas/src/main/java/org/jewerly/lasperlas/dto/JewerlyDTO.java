package org.jewerly.lasperlas.dto;

public record JewerlyDTO(
        Long identificationNumber,
        String name,
        String material,
        Double weight,
        String particularity,
        Boolean hasStone,
        Boolean isOnSale
) {
}
