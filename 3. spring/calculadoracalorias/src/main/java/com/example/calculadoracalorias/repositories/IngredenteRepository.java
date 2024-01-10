package com.example.calculadoracalorias.repositories;

import com.example.calculadoracalorias.entities.Ingrediente;
import com.example.calculadoracalorias.repositories.interfaces.CrudRepository;
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
public class IngredenteRepository implements CrudRepository<Ingrediente> {

    private List<Ingrediente> ingredienteList = new ArrayList<>();

    public IngredenteRepository(){
        ingredienteList = loadData();
    }

    private ArrayList<Ingrediente> loadData() {
        ArrayList<Ingrediente> data = null;
        File file;
        ObjectMapper objectMapper = new ObjectMapper();

        objectMapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);

        TypeReference<ArrayList<Ingrediente>> typeRef = new TypeReference<>() {};
        try {
            file = ResourceUtils.getFile("classpath:json/food.json");
            data = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

    @Override
    public Optional<Ingrediente> findByName(String name) {
        return ingredienteList.stream()
                .filter(p -> p.getName().equals(name))
                .findFirst();
    }

    @Override
    public List<Ingrediente> findAll() {
        return ingredienteList;
    }

}
