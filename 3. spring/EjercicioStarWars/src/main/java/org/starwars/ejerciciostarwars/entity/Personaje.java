package org.starwars.ejerciciostarwars.entity;

import lombok.*;

@AllArgsConstructor
@Getter
@NoArgsConstructor
@Setter
@EqualsAndHashCode
@ToString
public class Personaje {
    Integer id;
    String name;
    Integer height;
    Integer mass;
    String hairColor;
    String skinColor;
    String eyeColor;
    String birthYear;
    String gender;
    String homeworld;
    String species;

}
