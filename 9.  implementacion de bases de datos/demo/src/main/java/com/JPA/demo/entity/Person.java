package com.JPA.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Person {
    private Integer id;
    private String firstname;
    private String lastname;
    private String dni;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE, pattern = "dd/MM/yyyy")
    private LocalDate birthDate;
    private Short age;
    private Double salary;

}
