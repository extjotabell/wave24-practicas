package com.example.calculadoracalorias.repositories;

import com.example.calculadoracalorias.entities.Plato;
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
public class PlatoRepository implements CrudRepository<Plato> {

    private List<Plato> platoList = new ArrayList<>();



    public PlatoRepository(){
        platoList = loadData();
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
    public Optional<Plato> findByName(String name) {
        return platoList.stream()
                .filter(p -> p.getName().equals(name))
                .findFirst();
    }

    @Override
    public List<Plato> findAll() {
        return platoList;
    }
}
