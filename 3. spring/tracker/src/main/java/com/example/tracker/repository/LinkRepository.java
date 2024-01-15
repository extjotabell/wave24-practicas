package com.example.tracker.repository;

import com.example.tracker.entity.Link;
import com.example.tracker.excepciones.EmptyArray;
import com.example.tracker.excepciones.NoResourceFoundException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class LinkRepository implements ILinkRepository{


    private List<Link> links = new ArrayList<>(); //almacenar links
    private  Integer ids = 0;


    public LinkRepository(List<Link> links) {
        this.links = new ArrayList<>();
    }


    @Override
    public Link save(String url) {
        Integer id= this.ids += 1;
        Link link = new Link(id, url, 0);
        this.links.add(link);
        return link;
    }

    @Override
    public Link update(Link link) {
        return null;
    }

    @Override
    public Boolean deleteById(Integer id) {
        return null;
    }

    @Override
    public Optional<Link> findById(Integer id) throws NoResourceFoundException {
        if(this.links.isEmpty()){
            throw new EmptyArray("No hay informacion");
        }
        return this.links.stream().filter(link -> link.getLinkId().equals(id)).findFirst();
    }

    @Override
    public List<Link> findAll() {
        return this.links;
    }
}
