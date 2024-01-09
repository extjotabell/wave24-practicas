package com.mercadolibre.covidexercise.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public class Person {
    private String id;
    private String firstName;
    private String lastName;
    private Integer age;
}
