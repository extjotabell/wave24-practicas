package com.example.qatesters.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public record TestCaseDTO(Long id_case,
                          String description,
                          Boolean tested,
                          Boolean passed,
                          int number_of_tries,
                          @JsonFormat(pattern="dd-MM-yyyy")
                          LocalDate last_update
) {
}
