package com.jpa.integrador.mapper;

import com.jpa.integrador.dto.request.SaleRequestDTO;
import com.jpa.integrador.dto.response.SaleResponseDTO;
import com.jpa.integrador.entity.Sale;

public class SaleMapper {
    private final ClothMapper clothMapper = new ClothMapper();

    public Sale saleRequestDtoToSaleEntity(SaleRequestDTO saleRequestDTO) {
        return new Sale(
                saleRequestDTO.id(),
                saleRequestDTO.date(),
                saleRequestDTO.totalAmount(),
                saleRequestDTO.paymentMethod(),
                saleRequestDTO.cloth().stream().map(
                        clothMapper::clothRequestDtoToClothEntity
                ).toList()
        );
    }

    public SaleResponseDTO saleEntityToSaleResponseDTO(Sale sale) {
        return new SaleResponseDTO(
                sale.getId(),
                sale.getDate(),
                sale.getTotalAmount(),
                sale.getPaymentMethod(),
                sale.getClothes().stream().map(
                        clothMapper::clothEntityToClothResponseDto
                ).toList()
        );
    }
}
