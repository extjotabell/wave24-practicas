package com.jpa.integrador.dto.response;

import com.jpa.integrador.domain.Cloth;

public record ClothesResponseDTO(
        Integer id,
        String name,
        String brand,
        String color,
        String size,
        Integer quantity,
        Double salePrice) {

    public ClothesResponseDTO(Cloth cloth) {
        this(
                cloth.getId(),
                cloth.getName(),
                cloth.getBrand(),
                cloth.getColor(),
                cloth.getSize(),
                cloth.getQuantity(),
                cloth.getSalePrice()
        );
    }
}
