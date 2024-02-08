package org.movies.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public record MovieResponseDTO(
    Long id,
    String title,
    @JsonProperty("release_date")
    LocalDate releaseDate,
    Long length,
    Double rating,
    Long awards) {
}
