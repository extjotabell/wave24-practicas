package com.example.food.repository;

import com.example.food.entity.Dish;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.stream.Collectors;

@Repository
public class DishRepository implements IDishRepository {

    private ArrayList<Dish> dishList;

    public DishRepository(ArrayList<Dish> dishList) {
        this.dishList = loadData();
    }

    public DishRepository() {
        System.out.println("Se esta inicializando el repository");
        this.dishList = loadData();
    }
    @Override
    public Dish findByName(String name) {
        return this.dishList.stream()
                .filter(f -> f.getName().toLowerCase().contains(name.toLowerCase()))
                .findFirst().orElse(null);
    }

    @Override
    public ArrayList<Dish> findAllByNameAndWeight(String name,Integer weight) {
        return this.dishList.stream()
                .filter(f -> f.getName().toLowerCase().contains(name.toLowerCase()))
                .filter(f -> f.getWeight().equals(weight))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    private ArrayList<Dish> loadData() {
        ArrayList<Dish> data = null;
        File file;
        ObjectMapper objectMapper = new ObjectMapper();

        objectMapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);

        TypeReference<ArrayList<Dish>> typeRef = new TypeReference<>() {};
        try {
            file = ResourceUtils.getFile("classpath:json/dishes.json");
            data = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
}