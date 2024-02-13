package com.jpa.integrador.dto.request;

import com.jpa.integrador.domain.Cloth;

public record ClothRequestDTO(
        Integer id,
        String name,
        String brand,
        String color,
        String size,
        Integer quantity,
        Double salePrice
) {
    public ClothRequestDTO(Cloth cloth) {
        this(
                cloth.getId(),
                cloth.getName(),
                cloth.getBrand(),
                cloth.getColor(),
                cloth.getSize(),
                cloth.getQuantity(),
                cloth.getSalePrice());
    }
}

