package org.calculadoracalorias.ejerciciocalculadoracalorias.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@AllArgsConstructor
@Getter
@NoArgsConstructor
@Setter

public class Plato {

    private String name;
    private ArrayList<String> ingredients;
}
