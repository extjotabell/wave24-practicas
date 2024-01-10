package org.mercadolibre.co.calorias.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import org.mercadolibre.co.calorias.entity.Ingrendiente;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

@Repository
public class IngredienteRepositoryImpl implements IIngredienteRespository{

    private ArrayList<Ingrendiente> data;

    public IngredienteRepositoryImpl() {
        this.data = loadData();
    }

    @Override
    public Ingrendiente create(Ingrendiente ingrendiente) {
        return null;
    }

    @Override
    public Ingrendiente update(Ingrendiente ingrendiente) {
        return null;
    }

    @Override
    public boolean delete(Integer integer) {
        return false;
    }

    @Override
    public Ingrendiente findById(Integer integer) {
        return null;
    }

    @Override
    public Optional<Ingrendiente> findAll() {
        return Optional.empty();
    }

    private ArrayList<Ingrendiente> loadData() {
        ArrayList<Ingrendiente> data = null;
        File file;
        ObjectMapper objectMapper = new ObjectMapper();

        TypeReference<ArrayList<Ingrendiente>> typeRef = new TypeReference<>() {};
        try {
            file = ResourceUtils.getFile("classpath:json/food.json");
            data = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

    @Override
    public Ingrendiente findByName(String name) {

        var ingrediente = data.stream().filter(i -> i.getName().equals(name)).findFirst();

        return ingrediente.orElse(null);
    }
}
