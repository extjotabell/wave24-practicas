package org.linktracker.ejerciciolinktracker.service;

import org.linktracker.ejerciciolinktracker.dto.LinkDTO;
import org.linktracker.ejerciciolinktracker.entity.Link;
import org.linktracker.ejerciciolinktracker.exception.BadRequestException;
import org.linktracker.ejerciciolinktracker.exception.NotFoundException;
import org.linktracker.ejerciciolinktracker.repository.ILinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

@Service
public class LinkService implements ILinkService {
    @Autowired
    private ILinkRepository linkRepository;

    @Override
    public Link createLink(String url, String password) {
        if (isValidURL(url)) {
            Link link = new Link(url, password);
            return linkRepository.save(link);
        } else {
            throw new BadRequestException("Invalid URL.");
        }
    }

    @Override
    public Link redirectLink(Integer linkId) {
        Link link = linkRepository.findById(linkId);
        if (link != null && link.getValid()) {
            link.incrementRedirectCount();
            return link;
        } else {
            throw new NotFoundException("Link with id " + linkId + " not found.");
        }
    }

    @Override
    public Integer getRedirectCount(Integer linkId) {
        Link link = linkRepository.findById(linkId);
        if (link == null) {
            throw new NotFoundException("Link with id " + linkId + " not found.");
        }
        return link.getRedirectCount();
    }

    @Override
    public void invalidateLink(Integer linkId) {
        Link link = linkRepository.findById(linkId);
        if (link == null) {
            throw new NotFoundException("Link with id " + linkId + " not found.");
        }
        link.setValid(false);
    }

    private boolean isValidURL(String url) {
        try {
            new URL(url).toURI();
            return true;
        } catch (MalformedURLException | URISyntaxException e) {
            return false;
        }
    }
}
