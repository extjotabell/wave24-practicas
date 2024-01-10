package org.mercadolibre.co.calorias.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.mercadolibre.co.calorias.entity.Plato;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;


@Repository
public class PlatoRepositoryImpl implements IPlatoRepository{

    private ArrayList<Plato> platos;

    public PlatoRepositoryImpl() {
        this.platos = loadData();
    }

    @Override
    public Plato create(Plato plato) {
        return null;
    }

    @Override
    public Plato update(Plato plato) {
        return null;
    }

    @Override
    public boolean delete(Integer integer) {
        return false;
    }

    @Override
    public Plato findById(Integer integer) {
        return null;
    }

    @Override
    public Optional<Plato> findAll() {
        return Optional.empty();
    }

    private ArrayList<Plato> loadData() {
        ArrayList<Plato> data = null;
        File file;
        ObjectMapper objectMapper = new ObjectMapper();

        TypeReference<ArrayList<Plato>> typeRef = new TypeReference<>() {};
        try {
            file = ResourceUtils.getFile("classpath:json/platos.json");
            data = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

    public Plato findByName(String name) {

        var plato = this.platos.stream().filter(p -> p.getName().equals(name)).findFirst();

        return plato.orElse(null);
    }
}
