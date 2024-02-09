package org.showroom.showroom.dto.request;

import java.time.LocalDate;
import java.util.List;

public record SaleRequestDTO(
    String id,
    LocalDate date,
    Double totalAmount,
    String paymentMethod,
    List<ClothRequestDTO> cloth
){
}
