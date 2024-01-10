package org.calculadoracalorias.ejerciciocalculadoracalorias.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@NoArgsConstructor
@Setter
public class Comida {

    private String name;
    private Integer calories;
}
