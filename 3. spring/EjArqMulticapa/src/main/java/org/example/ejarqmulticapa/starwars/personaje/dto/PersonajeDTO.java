package org.example.ejarqmulticapa.starwars.personaje.dto;

import lombok.Value;
import org.example.ejarqmulticapa.starwars.personaje.entity.Personaje;

@Value
public class PersonajeDTO {

    String name;
    Double height;
    Double mass;
    String gender;
    String homeworld;
    String species;

    public static PersonajeDTO create(Personaje personaje) {
        return new PersonajeDTO(
                personaje.getName(),
                "NA".equals(personaje.getHeight()) ? 0 : Double.parseDouble(personaje.getHeight()),
                "NA".equals(personaje.getMass()) ? 0 : Double.parseDouble(personaje.getMass()),
                personaje.getGender(),
                personaje.getHomeworld(),
                personaje.getSpecies()
        );
    }
}
