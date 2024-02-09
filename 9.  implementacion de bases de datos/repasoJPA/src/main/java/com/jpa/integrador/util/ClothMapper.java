package com.jpa.integrador.util;

import com.jpa.integrador.dto.request.ClothRequestDTO;
import com.jpa.integrador.dto.response.ClothesResponseDTO;
import com.jpa.integrador.entity.Cloth;

public class ClothMapper {
    public static Cloth mapDTOToClothEntity(ClothRequestDTO clothRequestDTO){
        return new Cloth(
                clothRequestDTO.id(),
                clothRequestDTO.name(),
                clothRequestDTO.brand(),
                clothRequestDTO.color(),
                clothRequestDTO.size(),
                clothRequestDTO.quantity(),
                clothRequestDTO.salePrice()
        );
    }

    public static ClothesResponseDTO mapEntityToDTO(Cloth cloth){
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
}
