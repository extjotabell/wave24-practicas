package com.practicas.linkTracker.service;

import com.practicas.linkTracker.dto.LinkIdDTO;
import com.practicas.linkTracker.dto.LinkInvalidDTO;
import com.practicas.linkTracker.dto.LinkMetricDTO;
import com.practicas.linkTracker.entity.Link;
import com.practicas.linkTracker.entity.PasswordHashing;
import com.practicas.linkTracker.exception.BadUrlException;
import com.practicas.linkTracker.exception.CrudException;
import com.practicas.linkTracker.exception.InvalidRequestException;
import com.practicas.linkTracker.repository.LinkRepository;
import org.springframework.stereotype.Service;

import java.net.MalformedURLException;
import java.net.URL;

@Service
public class LinkService {
    private final LinkRepository linkRepository;

    public LinkService(LinkRepository linkRepository) {
        this.linkRepository = linkRepository;
    }


    public LinkIdDTO saveLink(Link link) {
        if (!this.isValidURL(link.getUrl()))
            throw new BadUrlException("La URL no es valida");

        var links = this.linkRepository.findAll().stream().filter(
                link1 -> link1.getUrl().equals(link.getUrl())
        ).count();
        if (links > 0)
            throw new CrudException("El Link ya existe");

        if (link.getPassword()==null || link.getPassword().trim().isEmpty())
            throw new InvalidRequestException("El password es obligatorio");

        var linkSaved = this.linkRepository.save(link);
        if (linkSaved==null)
            throw new CrudException("El link no fue almacenado");

        return new LinkIdDTO(link.getLinkId());
    }

    public Link getLinkById(Integer linkId, String password) {
        if (password.trim().isEmpty())
            throw new InvalidRequestException("El password es obligatorio");

        Link link = this.linkRepository.findById(linkId).orElseThrow(() -> new CrudException("El id " + linkId + " no existe"));

        if (!PasswordHashing.verifyPassword(password, link.getPassword(), link.getSalt()))
            throw new InvalidRequestException("La password no es valida");

        if (!this.isValidURL(link.getUrl()) || !link.getValid())
            throw new BadUrlException("El link no es valido");

        link.setRedirects(link.getRedirects()+1);
        link = this.linkRepository.update(link);

        if (link == null)
            throw new CrudException("No fue posible actualizar el redirect");

        return link;
    }

    public LinkMetricDTO getRedirectsById(Integer linkID) {
        return new LinkMetricDTO(
                this.linkRepository.findById(linkID).orElseThrow(() -> new CrudException("El id " + linkID + " no existe")).getRedirects()
        );
    }

    public LinkInvalidDTO invalidateLink(Integer linkId) {
        Link link = this.linkRepository.findById(linkId).orElseThrow(() -> new CrudException("El id " + linkId + " no existe"));

        link.setValid(false);
        link = this.linkRepository.update(link);

        return new LinkInvalidDTO(link.getValid());
    }

    private Boolean isValidURL(String url) {
        try {
            new URL(url);
            return true;
        } catch (MalformedURLException e) {
            return false;
        }
    }
}
