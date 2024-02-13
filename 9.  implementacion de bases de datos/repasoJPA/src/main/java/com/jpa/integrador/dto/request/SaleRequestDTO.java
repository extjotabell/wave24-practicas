package com.jpa.integrador.dto.request;

import com.jpa.integrador.entity.Sale;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public record SaleRequestDTO(
    Integer id,
    LocalDate date,
    Double totalAmount,
    String paymentMethod,
    List<ClothRequestDTO> clothes
){
    public Sale dtoToSale() {
        return new Sale(
                id,
                date,
                totalAmount,
                paymentMethod,
                clothes.stream().map(ClothRequestDTO::dtoToClothInStorage).collect(Collectors.toSet())
        );
    }

    public Sale assign(Sale sale) {
        Optional.ofNullable(date).ifPresent(sale::setDate);
        Optional.ofNullable(totalAmount).ifPresent(sale::setTotalAmount);
        Optional.ofNullable(paymentMethod).ifPresent(sale::setPaymentMethod);

        return sale;
    }

    public static SaleRequestDTO of(Sale sale) {
        return new SaleRequestDTO(
                sale.getId(),
                sale.getDate(),
                sale.getTotalAmount(),
                sale.getPaymentMethod(),
                sale.getClothes().stream().map(ClothRequestDTO::of).toList()
        );
    }
}
