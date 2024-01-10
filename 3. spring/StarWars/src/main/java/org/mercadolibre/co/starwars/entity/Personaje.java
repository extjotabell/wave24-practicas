package org.mercadolibre.co.starwars.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class Personaje {

    private String name;

    private Integer height;

    private Integer mass;

    private String hairColor;

    private String skinColor;

    private String eyeColor;

    private String birthDate;

    private String gender;

    private String homeWorld;

    private String species;

}


