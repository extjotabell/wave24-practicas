package com.practica.covid19.records;

import com.practica.covid19.classes.Symptom;

import java.util.List;

public record RiskPerson(String name, String lastName, List<Symptom> symptoms ) {
}