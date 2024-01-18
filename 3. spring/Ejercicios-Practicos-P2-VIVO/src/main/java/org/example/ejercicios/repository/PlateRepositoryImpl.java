package org.example.ejercicios.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.ejercicios.entity.Plate;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;
import org.springframework.web.server.ResponseStatusException;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class PlateRepositoryImpl implements IPlateRepository {

    private final List<Plate> plates;

    public PlateRepositoryImpl() {
        plates = new ArrayList<>();
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


}