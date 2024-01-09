package com.practica.covid19.classes;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Person {
    private Integer id;
    private String name;
    private String lastName;
    private int age;
    private List<Symptom> symptoms;
}