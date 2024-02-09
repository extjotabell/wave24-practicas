package org.showroom.showroom.dto.response;

import org.showroom.showroom.dto.request.ClothRequestDTO;

import java.time.LocalDate;
import java.util.List;

public record SaleResponseDTO(
        String id,
        LocalDate date,
        Double totalAmount,
        String paymentMethod,
        List<ClothRequestDTO> cloth){

}
