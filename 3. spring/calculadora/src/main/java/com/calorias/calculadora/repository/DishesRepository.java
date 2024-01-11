package com.calorias.calculadora.repository;

import com.calorias.calculadora.model.Dishes;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class DishesRepository implements ICrudRepository<Dishes> {

    private String jsonFile = "classpath:json/dishes.json";
    ArrayList<Dishes> data;

    public DishesRepository() {
        this.data = this.load();
    }

    @Override
    public List<Dishes> findAll() {
        return this.data;
    }

    @Override
    public Optional<Dishes> findByName(String name) {
        return this.data.stream().filter((row) -> row.getName().equalsIgnoreCase(name)).findFirst();
    }

    private ArrayList<Dishes> load(){
        ArrayList<Dishes> data = null;
        File file;
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
        TypeReference<ArrayList<Dishes>> typeRef = new TypeReference<>() {};
        try {
            file = ResourceUtils.getFile(this.jsonFile);
            data = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
}
