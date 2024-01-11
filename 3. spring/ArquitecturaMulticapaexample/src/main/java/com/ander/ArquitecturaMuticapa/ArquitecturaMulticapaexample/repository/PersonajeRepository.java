package com.ander.ArquitecturaMuticapa.ArquitecturaMulticapaexample.repository;

import com.ander.ArquitecturaMuticapa.ArquitecturaMulticapaexample.entity.Personaje;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class PersonajeRepository implements IPersonajeRepository{

    //almacenarmiento opcional porque no usamos bd

    private List<Personaje> personajes;

    public PersonajeRepository(List personajes) {
        this.personajes = loadData();
        System.out.println("Se inicializa el repository");
    }

    @Override
    public Personaje save(Personaje personaje) {
        return null;
    }

    @Override
    public Personaje update(Personaje personaje) {
        return null;
    }

    @Override
    public Boolean deleteById(Integer id) {
        return null;
    }

    @Override
    public Optional<Personaje> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public List<Personaje> findAll() {
        return this.personajes;
    }

    @Override
    public List<Personaje> findByName(String name) {
        System.out.println("Se inicializa el repository");
        //BUSCA EN LOS DATOS LOS QUE COINCIDAN
         return this.personajes.stream()
                .filter(p -> p.getName().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
    }

    //metodo para cargar data
    private List<Personaje> loadData() {
        List<Personaje> data = null;
        File file;
        //clase para la serializacion de datos
        ObjectMapper objectMapper = new ObjectMapper();

        //todo sera convertido a snake case
        objectMapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);

        TypeReference<List<Personaje>> typeRef = new TypeReference<>() {};
        try {
            file = ResourceUtils.getFile("classpath:json/starwars.json");
            data = objectMapper.readValue(file, typeRef);
            System.out.println(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
}
