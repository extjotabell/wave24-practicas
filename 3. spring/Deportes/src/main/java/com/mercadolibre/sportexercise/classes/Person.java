package com.mercadolibre.sportexercise.classes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class Person {
    private String firstName;
    private String lastName;
    private Integer age;
}
