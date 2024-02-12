package org.example.qatester.dto;

import java.time.LocalDate;

public record TestCaseDto(
        Long idCase,
        String description,
        Boolean tested,
        Boolean passed,
        Integer numberOfTries,
        LocalDate lastUpdate
) {
}
