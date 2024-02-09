package com.jpa.integrador.dto.response;

import java.time.LocalDate;
import java.util.List;

public record SaleResponseDTO(
        Integer id,
        LocalDate date,
        Double totalAmount,
        String paymentMethod,
        List<ClothesResponseDTO> cloth
){
}
