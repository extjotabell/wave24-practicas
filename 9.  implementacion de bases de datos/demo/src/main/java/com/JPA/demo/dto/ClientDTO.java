package com.JPA.demo.dto;

import com.JPA.demo.entity.Client;

public record ClientDTO(
    Integer id,
    String email,
    String cardNumber,
    PersonDTO personDTO
){
}
