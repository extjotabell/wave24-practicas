package org.mercadolibre.co.consigna.service;


import org.mercadolibre.co.consigna.dto.LinkDTO;
import org.mercadolibre.co.consigna.entity.Link;
import org.mercadolibre.co.consigna.exception.InvalidUrlException;
import org.mercadolibre.co.consigna.repository.ILinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.regex.Pattern;

@Service
public class LinkServiceImpl implements ILinkService{

    @Autowired
    private ILinkRepository linkRepository;

    @Override
    public LinkDTO create(Link link) {

        Pattern pattern = Pattern.compile("^(https?|ftp):/\\/[^\\s/$.?#].[^\\s]*$");
        if(!pattern.matcher(link.getUrl()).matches()){
            throw new InvalidUrlException("Invalid URL");
        }


        this.linkRepository.save(link);

        LinkDTO linkDTO = new LinkDTO(link.getUrl(),link.getId());

        return linkDTO;
    }

    @Override
    public LinkDTO redirect(Integer linkId) {

        Link link = this.linkRepository.findById(linkId).get();



        return null;
    }
}
