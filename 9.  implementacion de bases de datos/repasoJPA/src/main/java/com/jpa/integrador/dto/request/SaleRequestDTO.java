package com.jpa.integrador.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.util.List;

public record SaleRequestDTO(
    Integer id,
    @JsonFormat(pattern ="yyyy-MM-dd")
    LocalDate date,
    Double totalAmount,
    String paymentMethod,
    List<ClothRequestDTO> cloth
){
}
