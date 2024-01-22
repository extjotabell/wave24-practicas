package com.exceptions.starwars.dto;

public record PersonajeCompleteDTO(
        Integer id,
        String name,
        Integer height,
        Integer mass,
        String hairColor,
        String skinColor,
        String eyeColor,
        String birthYear,
        String gender,
        String homeworld,
        String species
) {
}
