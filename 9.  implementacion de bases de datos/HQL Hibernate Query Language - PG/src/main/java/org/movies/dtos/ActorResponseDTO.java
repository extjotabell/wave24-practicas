package org.movies.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ActorResponseDTO(
        String firstName,
        String lastName,
        Double rating,
        @JsonProperty("favorite_movie")
        MovieResponseDTO favoriteMovie
) {
}
