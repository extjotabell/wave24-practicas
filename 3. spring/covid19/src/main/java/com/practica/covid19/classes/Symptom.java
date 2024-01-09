package com.practica.covid19.classes;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Symptom {
    private String code;
    private String name;
    private String severityLevel;
}