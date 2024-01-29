package com.Characters.character.dto;

public record PersonajeInfoDTO(
        Integer id,
        String name,
        Integer height,
        Integer mass,
        String gender,
        String homeworld,
        String species
) {
}