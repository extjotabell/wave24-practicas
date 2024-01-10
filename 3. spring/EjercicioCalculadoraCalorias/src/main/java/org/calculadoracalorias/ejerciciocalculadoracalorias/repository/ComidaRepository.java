package org.calculadoracalorias.ejerciciocalculadoracalorias.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import org.calculadoracalorias.ejerciciocalculadoracalorias.entity.Comida;
import org.calculadoracalorias.ejerciciocalculadoracalorias.entity.Plato;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

@Repository
public class ComidaRepository implements IComidaRepository {
    ArrayList<Comida> comidas;
    public ComidaRepository() {
        this.comidas = loadData();
    }
    private ArrayList<Comida> loadData() {
        ArrayList<Comida> data = null;
        File file;
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE);
        TypeReference<ArrayList<Comida>> typeRef = new TypeReference<>() {};
        try {
            file = ResourceUtils.getFile("classpath:json/food.json");
            data = objectMapper.readValue(file, typeRef);
        }catch (IOException e){
            e.printStackTrace();
        }
        return data;

    }
    @Override
    public Comida findByName(String name) {
        return this.comidas.stream()
                .filter(comida -> comida.getName().toLowerCase()
                        .contains(name.toLowerCase())).findFirst().orElse(null);
    }
}
