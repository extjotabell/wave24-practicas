package com.bootcamp.calories.entity;

import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
public class Plate {

    private String name;
    private List<String> ingredients;

}