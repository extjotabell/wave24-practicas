package com.mercadolibre.linktrackerexercise.service;

import com.mercadolibre.linktrackerexercise.dto.CreateLinkDTO;
import com.mercadolibre.linktrackerexercise.dto.LinkIdDTO;
import com.mercadolibre.linktrackerexercise.dto.LinkQuantityRedirectDTO;
import com.mercadolibre.linktrackerexercise.entity.LinkEntity;
import com.mercadolibre.linktrackerexercise.exception.BadRequestException;
import com.mercadolibre.linktrackerexercise.exception.NotFoundException;
import com.mercadolibre.linktrackerexercise.repository.ILinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.MalformedURLException;
import java.net.URL;

@Service
public class LinkServiceImpl implements ILinkService {
    @Autowired
    private ILinkRepository linkRepository;

    @Override
    public LinkIdDTO createLink(CreateLinkDTO createLinkDTO) {
        if(!validateUrl(createLinkDTO.url())){
            throw new BadRequestException("La url no es valida");
        }
        Integer id = this.linkRepository.findAll().size();
        LinkEntity linkCreated = this.linkRepository.create(
                new LinkEntity(id, createLinkDTO.url(), 0, true)
        );

        return new LinkIdDTO(linkCreated.getId());
    }

    @Override
    public String redirectLink(Integer linkId) {
        LinkEntity linkToRedirect = this.linkRepository.findByID(linkId)
                .orElseThrow(() -> new NotFoundException("Link no encontrado"));

        if(!linkToRedirect.getIsValid()){
            throw new BadRequestException("Link is not valid");
        }

        linkToRedirect.setQuantityRedirections(linkToRedirect.getQuantityRedirections() + 1);
        this.linkRepository.update(linkToRedirect);

        return linkToRedirect.getUrl();
    }

    @Override
    public LinkQuantityRedirectDTO getLinkQuantityRedirect(Integer linkId) {
        LinkEntity linkFinded = this.linkRepository.findByID(linkId)
                .orElseThrow(() -> new NotFoundException("Link no encontrado"));

        return new LinkQuantityRedirectDTO(linkFinded.getQuantityRedirections());
    }

    @Override
    public Boolean invalidateLink(Integer linkId) {
        LinkEntity linkToRedirect = this.linkRepository.findByID(linkId)
                .orElseThrow(() -> new NotFoundException("Link no encontrado"));

        linkToRedirect.setIsValid(false);
        this.linkRepository.update(linkToRedirect);

        return true;
    }

    private Boolean validateUrl(String url){
        try {
            new URL(url);
            return true;
        } catch (MalformedURLException e){
            return false;
        }
    }
}
