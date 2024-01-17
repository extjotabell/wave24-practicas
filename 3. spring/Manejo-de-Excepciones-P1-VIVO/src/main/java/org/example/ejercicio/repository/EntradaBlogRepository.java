package org.example.ejercicio.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import org.example.ejercicio.entity.EntradaBlog;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

@Repository
public class EntradaBlogRepository implements IEntradaBlogRepository{

    private ArrayList<EntradaBlog> entradaBlogs;

    public EntradaBlogRepository() {
        entradaBlogs = new ArrayList<>();
    }
    @Override
    public EntradaBlog save(EntradaBlog entradaBlog) {
        if(entradaBlogs.stream().filter(x -> x.getId().equals(entradaBlog.getId())).findFirst().isEmpty()) {
            entradaBlogs.add(entradaBlog);
            return entradaBlog;
        }
        return null;
    }

    @Override
    public EntradaBlog update(EntradaBlog entradaBlog) {
        return null;
    }

    @Override
    public Boolean deleteById(Integer id) {
        return null;
    }

    @Override
    public Optional<EntradaBlog> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public ArrayList<EntradaBlog> findAll() {
        return null;
    }

    @Override
    public EntradaBlog findById(Long id) {
        return entradaBlogs.stream().filter(x -> x.getId().equals(id)).findFirst().orElse(null);
    }
}
