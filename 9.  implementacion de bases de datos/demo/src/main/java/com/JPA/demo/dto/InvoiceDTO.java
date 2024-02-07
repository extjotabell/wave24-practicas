package com.JPA.demo.dto;


import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public record InvoiceDTO(
    Integer id,
    LocalDate date
    ){
}
