package com.Characters.character.dto;
public record PersonajeDTO(
        String name,
        Integer height,
        Integer mass,
        String gender,
        String homeworld,
        String species

) {
    public PersonajeDTO(String name, Integer height, Integer mass, String gender, String homeworld, String species) {
        this.name = name;
        this.height = height;
        this.mass = mass;
        this.gender = gender;
        this.homeworld = homeworld;
        this.species = species;
    }
}