package com.jpa.integrador.dto.response;

import com.jpa.integrador.entity.Cloth;
import com.jpa.integrador.entity.Sale;

import java.util.HashSet;
import java.util.Set;

public record ClothesResponseDTO (
    Integer id,
    String name,
    String brand,
    String color,
    String size,
    Integer quantity,
    Double salePrice
){
    public static ClothesResponseDTO of(Cloth cloth) {
        return new ClothesResponseDTO(
                cloth.getId(),
                cloth.getName(),
                cloth.getBrand(),
                cloth.getColor(),
                cloth.getSize(),
                cloth.getQuantity(),
                cloth.getSalePrice()
        );
    }

    public Cloth dtoToClothInStorage() {
        return new Cloth(
                id,
                name,
                brand,
                color,
                size,
                quantity,
                salePrice,
                new HashSet<>()
        );
    }

    public Cloth dtoToClothSold(Set<Sale> sales) {
        return new Cloth(
                id,
                name,
                brand,
                color,
                size,
                quantity,
                salePrice,
                sales
        );
    }
}
