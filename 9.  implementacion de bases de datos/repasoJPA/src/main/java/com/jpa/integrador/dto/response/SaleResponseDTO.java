package com.jpa.integrador.dto.response;


import com.jpa.integrador.dto.request.ClothRequestDTO;

import java.time.LocalDate;
import java.util.List;

public record SaleResponseDTO(
        Integer id,
        LocalDate date,
        Double totalAmount,
        String paymentMethod,
        List<ClothRequestDTO> cloth){

}
