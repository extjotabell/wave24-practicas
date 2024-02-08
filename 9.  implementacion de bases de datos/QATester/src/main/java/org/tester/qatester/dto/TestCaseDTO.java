package org.tester.qatester.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public record TestCaseDTO (
        Long idCase,
        String description,
        Boolean tested,
        Boolean passed,
        Integer numberOfTries,
        @JsonFormat(pattern = "dd/MM/yyyy")
        LocalDate lastUpdate
){
}
