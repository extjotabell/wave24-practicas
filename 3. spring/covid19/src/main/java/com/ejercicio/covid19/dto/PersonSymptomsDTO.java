package com.ejercicio.covid19.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class PersonSymptomsDTO {

    private String firstName;
    private String lastName;
    private String symptomName;

}



