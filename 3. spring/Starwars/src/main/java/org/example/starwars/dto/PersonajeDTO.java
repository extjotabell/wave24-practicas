package org.example.starwars.dto;

public record PersonajeDTO(
        String name,
        String gender,
        double height,
        Double mass,
        String homeworld,
        String species
) {

    public PersonajeDTO(String name, String gender, double height, Double mass, String homeworld, String species) {
        this.name = name;
        this.gender = gender;
        this.height = height;
        this.mass = mass;
        this.homeworld = homeworld;
        this.species = species;
    }
}
