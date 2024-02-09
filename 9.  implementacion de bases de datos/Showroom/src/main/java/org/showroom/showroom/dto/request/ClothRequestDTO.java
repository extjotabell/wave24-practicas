package org.showroom.showroom.dto.request;

public record ClothRequestDTO(
        String id,
        String name,
        String brand,
        String color,
        String size,
        Integer quantity,
        Double salePrice
)
{}

