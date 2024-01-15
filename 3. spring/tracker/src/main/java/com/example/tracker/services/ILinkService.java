package com.example.tracker.services;

import com.example.tracker.dto.IdLinkDTO;
import com.example.tracker.dto.LinkDTO;

import java.util.Optional;

public interface ILinkService {

    IdLinkDTO createLink(String ulr);
    Integer estadisticaLink(String url);
    Boolean invalidarLink(String url );

    String getLink(Integer id);


}
