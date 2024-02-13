package com.jpa.integrador.dto.request;

import com.jpa.integrador.entity.Cloth;
import com.jpa.integrador.entity.Sale;

import java.util.HashSet;
import java.util.Optional;

public record ClothRequestDTO(
        Integer id,
        String name,
        String brand,
        String color,
        String size,
        Integer quantity,
        Double salePrice
) {
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

    public Cloth assign(Cloth cloth) {
        Optional.ofNullable(name).ifPresent(cloth::setName);
        Optional.ofNullable(brand).ifPresent(cloth::setBrand);
        Optional.ofNullable(color).ifPresent(cloth::setColor);
        Optional.ofNullable(size).ifPresent(cloth::setSize);
        Optional.ofNullable(quantity).ifPresent(cloth::setQuantity);
        Optional.ofNullable(salePrice).ifPresent(cloth::setSalePrice);

        return cloth;
    }

    public static ClothRequestDTO of(Cloth cloth) {
        return new ClothRequestDTO(
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

