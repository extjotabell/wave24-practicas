package org.showroom.showroom.dto.response;

public record ClothesResponseDTO (
    String id,
    String name,
    String brand,
    String color,
    String size,
    Integer quantity,
    Double salePrice){
}
