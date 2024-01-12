package com.mercadolibre.linktrackerexercise.service;

import com.mercadolibre.linktrackerexercise.dto.CreateLinkDTO;
import com.mercadolibre.linktrackerexercise.dto.LinkIdDTO;
import com.mercadolibre.linktrackerexercise.dto.LinkQuantityRedirectDTO;

import java.net.MalformedURLException;

public interface ILinkService {
    public LinkIdDTO createLink(CreateLinkDTO createLinkDTO);
    public String redirectLink(Integer linkId);
    public LinkQuantityRedirectDTO getLinkQuantityRedirect(Integer linkId);
    public Boolean invalidateLink(Integer linkId);
}
