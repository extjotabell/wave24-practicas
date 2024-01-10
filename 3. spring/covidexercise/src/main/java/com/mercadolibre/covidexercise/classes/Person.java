package com.mercadolibre.covidexercise.classes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
@AllArgsConstructor
public class Person {
    private String id;
    private String firstName;
    private String lastName;
    private Integer age;
    private List<Symptom> symptoms;
}
