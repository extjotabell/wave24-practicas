package com.jpa.integrador.dto.request;

public record ClothRequestDTO(
        Integer id,
        String name,
        String brand,
        String color,
        String size,
        Integer quantity,
        Double salePrice
)
{}

