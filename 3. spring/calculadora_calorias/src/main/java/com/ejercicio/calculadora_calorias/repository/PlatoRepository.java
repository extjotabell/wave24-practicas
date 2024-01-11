package com.ejercicio.calculadora_calorias.repository;

import com.ejercicio.calculadora_calorias.entity.Ingrediente;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;
import java.io.File;
import java.io.IOException;

import com.ejercicio.calculadora_calorias.entity.Plato;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Repository
public class PlatoRepository implements ICrudRepository{

    private List<Plato> platoList;

    public PlatoRepository() {

        this.platoList = loadData();
    }

    private ArrayList<Plato> loadData() {
        ArrayList<Plato> data = null;
        File file;
        ObjectMapper objectMapper = new ObjectMapper();

        objectMapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);

        TypeReference<ArrayList<Plato>> typeRef = new TypeReference<>() {};
        try {
            file = ResourceUtils.getFile("classpath:json/plato.json");
            data = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

    @Override
    public Optional<Plato> findByName(String name){
        return platoList.stream()
                .filter(p -> p.getName().equals(name))
                .findFirst();
    }

    @Override
    public List<Plato> findAll() {
        return platoList;
    }

}