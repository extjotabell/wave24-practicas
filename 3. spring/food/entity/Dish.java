package com.example.food.entity;

import lombok.*;

import java.util.List;
@ToString
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Dish {
    String name;
    Integer weight;
    List<String> ingredients;
}