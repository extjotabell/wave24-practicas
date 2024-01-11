package com.practica.calculadora.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.practica.calculadora.entity.Plate;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class PlateRepository implements IPlateRepository {
    private ArrayList<Plate> plates;
    private final String URL_FILE = "classpath:json/plates.json";

    public PlateRepository() {
        this.plates = this.loadPlatesFromJson();
    }

    @Override
    public Plate save(Plate plate) {
        plate.setId(this.plates.size());

        if (this.plates.add(plate))
            return plate;

        return null;
    }

    @Override
    public Plate update(Plate plate) {
        var id = this.plates.indexOf(plate);

        if (id != -1) {
            this.plates.set(id, plate);
            return plate;
        }

        return null;
    }

    @Override
    public Boolean deleteById(Integer id) {
        return this.plates.removeIf(plate -> plate.getId().equals(id));
    }

    @Override
    public Optional<Plate> findById(Integer id) {
        return this.plates.stream().filter(
                plate -> plate.getId().equals(id)
        ).findFirst();
    }

    @Override
    public List<Plate> findAll() {
        return this.plates;
    }

    @Override
    public Optional<Plate> findPlateByName(String name) {
        return this.plates.stream().filter(
                plate -> plate.getName().equalsIgnoreCase(name)
        ).findFirst();
    }

    private ArrayList<Plate> loadPlatesFromJson() {
        ArrayList<Plate> data = null;
        File file;
        ObjectMapper objectMapper = new ObjectMapper().setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
        TypeReference<ArrayList<Plate>> typeReference = new TypeReference<>() {};
        try {
            file = ResourceUtils.getFile(URL_FILE);
            data = objectMapper.readValue(file, typeReference);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
}
