package com.jpa.integrador.dto.request;

import java.time.LocalDate;
import java.util.List;

public record SaleRequestDTO(
    Integer id,
    LocalDate date,
    Double totalAmount,
    String paymentMethod,
    List<ClothRequestDTO> clothList
){
}
