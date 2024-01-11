package com.ander.DTOexample.modelo;


import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
public class Adress {

    private Long id;
    private Customer customer;
    private String country;
    private String address;
}
