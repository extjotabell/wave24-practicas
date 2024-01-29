package com.Characters.character.entity;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
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