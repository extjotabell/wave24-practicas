package com.Link.link.repository;


import com.Link.link.entity.Link;
import com.Link.link.exceptions.NotFoundLinkException;
import com.Link.link.util.enums.CrudOperation;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Repository
public class LinkRepository implements ILinkRepository {
    List<Link> links;
    public LinkRepository(){
        this.links = loadData();
    }
    @Override
    public Link save(Link link) {
        link.setId(links.size());
        if(this.links.add(link))
            return link;
        return null;
    }
    @Override
    public Link update(Link link) {

        Optional<Link> linkReturn = this.links.stream().filter(link1 -> link1.getId() == link.getId()).findFirst();

        if (linkReturn.isPresent()) {
            Link linkUpdate = linkReturn.get();
            linkUpdate.setUrl(link.getUrl());
            return linkUpdate;
        }

        return null;
    }

    @Override
    public Boolean deleteByid(Integer id) {
        return null;
    }

    @Override
    public Optional<Link> findById(Link id) throws NotFoundLinkException {
        Optional<Link> linkReturn = this.links.stream().filter(link -> {
            return link.getId() == id.getId();
        }).findFirst();

        if (linkReturn.isPresent()) {
            return linkReturn;
        }

        throw new NotFoundLinkException(CrudOperation.READ,"Link not found");
    }
    @Override
    public ArrayList<Link> findAll() {
        return null;
    }
    private ArrayList<Link> loadData() {
        ArrayList<Link> data = new ArrayList<>();
        File file;
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);

        com.fasterxml.jackson.core.type.TypeReference<List<Link>> typeRef = new com.fasterxml.jackson.core.type.TypeReference<>() {
        };

        try {
            file = ResourceUtils.getFile("classpath:json/links.json");

            try (FileInputStream fileInputStream = new FileInputStream(file);
                 BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream)) {

                data = (ArrayList<Link>) objectMapper.readValue(bufferedInputStream, typeRef);
            } catch (IOException e) {
                // Manejo de la excepción o lanza una excepción personalizada si es apropiado para tu aplicación
                e.printStackTrace();
            }

        } catch (FileNotFoundException e) {
            // Manejo de la excepción o lanza una excepción personalizada si es apropiado para tu aplicación
            e.printStackTrace();
        }
        return data;
    }
}
