package com.JPA.demo.dto;


import com.JPA.demo.entity.Product;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

public record InvoiceDTO(
    Integer id,
    LocalDate date,

    ClientDTO clientDTO,

    List<ProductDTO> products
    ){
}
