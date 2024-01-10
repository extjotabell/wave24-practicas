package org.example.ejcocina.entity;

import lombok.Data;

import java.util.List;

@Data
public class Plate {

    private String name;
    private List<String> ingredients;

}
