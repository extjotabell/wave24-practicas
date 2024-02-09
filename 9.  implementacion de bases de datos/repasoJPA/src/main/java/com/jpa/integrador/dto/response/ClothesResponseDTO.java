package com.jpa.integrador.dto.response;

public record ClothesResponseDTO (
    Integer id,
    String name,
    String brand,
    String color,
    String size,
    Integer quantity,
    Double salePrice){
}
