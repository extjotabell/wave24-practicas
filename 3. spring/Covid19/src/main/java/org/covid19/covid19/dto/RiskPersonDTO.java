package org.covid19.covid19.dto;

import org.covid19.covid19.entity.Symptom;

import java.util.List;

public record RiskPersonDTO(String name, String surname, List<Symptom> symptoms) {
}
