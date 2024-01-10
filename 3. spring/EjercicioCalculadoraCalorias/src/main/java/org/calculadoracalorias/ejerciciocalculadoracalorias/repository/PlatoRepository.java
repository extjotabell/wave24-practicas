package org.calculadoracalorias.ejerciciocalculadoracalorias.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import org.calculadoracalorias.ejerciciocalculadoracalorias.entity.Plato;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.stream.Collectors;

@Repository
public class PlatoRepository implements IPlatoRepository {
    ArrayList<Plato> platos;

    public PlatoRepository() {
        this.platos = loadData();
    }

    private ArrayList<Plato> loadData() {
        ArrayList<Plato> data = null;
        File file;
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE);
        TypeReference<ArrayList<Plato>> typeRef = new TypeReference<>() {};
        try {
            file = ResourceUtils.getFile("classpath:json/dishes.json");
            data = objectMapper.readValue(file, typeRef);
        }catch (IOException e){
            e.printStackTrace();
        }
        return data;

    }

    @Override
    public Plato findByName(String name) {
        return this.platos.stream()
                .filter(plato -> plato.getName().toLowerCase()
                        .contains(name.toLowerCase())).findFirst().orElse(null);
    }
}
