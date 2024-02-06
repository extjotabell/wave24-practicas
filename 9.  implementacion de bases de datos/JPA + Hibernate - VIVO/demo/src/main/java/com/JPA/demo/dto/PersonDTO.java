package com.JPA.demo.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public record PersonDTO(
        Integer id,
        String firstname,
        String lastname,
        String dni,
        @JsonFormat(pattern = "dd/MM/yyyy")
        LocalDate birthDate,
        Short age,
        Double salary
){
}
