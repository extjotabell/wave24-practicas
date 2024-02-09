package com.jpa.integrador.mapper;

import com.jpa.integrador.dto.request.ClothRequestDTO;
import com.jpa.integrador.dto.response.ClothesResponseDTO;
import com.jpa.integrador.entity.Cloth;

public class ClothMapper {
    public Cloth clothRequestDtoToClothEntity(ClothRequestDTO clothRequestDTO){
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

    public ClothesResponseDTO clothEntityToClothResponseDto(Cloth cloth) {
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
