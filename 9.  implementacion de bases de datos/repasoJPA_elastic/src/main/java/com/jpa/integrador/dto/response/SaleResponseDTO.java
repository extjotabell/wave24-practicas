package com.jpa.integrador.dto.response;


import com.jpa.integrador.dto.request.ClothRequestDTO;
import com.jpa.integrador.entity.Sale;

import java.time.LocalDate;
import java.util.List;

public record SaleResponseDTO(
        String id,
        LocalDate date,
        Double totalAmount,
        String paymentMethod,
        List<ClothRequestDTO> cloth
){
public static SaleResponseDTO of(Sale sale) {
        return new SaleResponseDTO(
                sale.getId(),
                sale.getDate(),
                sale.getTotalAmount(),
                sale.getPaymentMethod(),
                sale
                        .getClothes()
                        .stream()
                        .map(ClothRequestDTO::of)
                        .toList()
        );
    }
}
