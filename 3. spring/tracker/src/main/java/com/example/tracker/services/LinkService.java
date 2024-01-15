package com.example.tracker.services;


import com.example.tracker.dto.IdLinkDTO;
import com.example.tracker.dto.LinkDTO;
import com.example.tracker.excepciones.NoResourceFoundException;
import com.example.tracker.repository.LinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LinkService implements ILinkService {


    @Autowired
    private LinkRepository linkRepository;


    @Override
    public IdLinkDTO createLink(String url) {
        var link = linkRepository.save(url);
        System.out.println(link);
        return new IdLinkDTO( link.getLinkId());

    }



    @Override
    public Integer estadisticaLink(String url) {
        return null;
    }

    @Override
    public Boolean invalidarLink(String url) {
        return null;
    }

    @Override
    public String getLink(Integer id) {
        var link = linkRepository.findById(id);
        if(link == null) {
            throw new NoResourceFoundException("hola");
        }

        return
    }
}
