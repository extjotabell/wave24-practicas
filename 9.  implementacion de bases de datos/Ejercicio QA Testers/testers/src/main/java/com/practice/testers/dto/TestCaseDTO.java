package com.practice.testers.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public record TestCaseDTO(
        @JsonProperty("id_case")
        Long idCase,
        String description,
        Boolean tested,
        Boolean passed,
        @JsonProperty("number_of_tries")
        int numberOfTries,
        @JsonProperty("last_updated")
        @JsonFormat(pattern ="dd-MM-yyyy")
        LocalDate lastUpdate
) {
}
