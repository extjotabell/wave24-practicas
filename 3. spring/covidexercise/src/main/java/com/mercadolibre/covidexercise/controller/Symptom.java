package com.mercadolibre.covidexercise.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
public class Symptom {
    private String code;
    private String name;
    private Integer severityLevel;
}
