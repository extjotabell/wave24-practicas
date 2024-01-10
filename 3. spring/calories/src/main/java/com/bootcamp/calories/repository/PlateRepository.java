package com.bootcamp.calories.repository;

import com.bootcamp.calories.entity.Plate;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;
import org.springframework.web.server.ResponseStatusException;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PlateRepository implements IPlateRepository {

    private final List<Plate> plates;

    public PlateRepository() {
        plates = loadData();
    }

    @Override
    public Plate save() {
        return null;
    }

    @Override
    public Plate update() {
        return null;
    }

    @Override
    public Boolean delete() {
        return null;
    }

    @Override
    public List<Plate> findAll() {
        return null;
    }

    @Override
    public Plate findById() {
        return null;
    }

    public Plate findByName(String name) {

        return plates
                .stream()
                .filter(plate -> plate.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No se encontro el plato"));

    }

    private ArrayList<Plate> loadData() {
        ArrayList<Plate> data = null;
        File file;
        ObjectMapper objectMapper = new ObjectMapper();

        TypeReference<ArrayList<Plate>> typeRef = new TypeReference<>() {};
        try {
            file = ResourceUtils.getFile("classpath:json/plates.json");
            data = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(data);
        return data;
    }
}