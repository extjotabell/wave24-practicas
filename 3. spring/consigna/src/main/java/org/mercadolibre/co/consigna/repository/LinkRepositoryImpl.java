package org.mercadolibre.co.consigna.repository;

import org.mercadolibre.co.consigna.entity.Link;
import org.mercadolibre.co.consigna.exception.NotFoundLinkException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class LinkRepositoryImpl implements ILinkRepository{

    List<Link> links;

    public LinkRepositoryImpl(){
        links = new ArrayList<>();
    }

    @Override
    public Link save(Link link) {
        links.add(link);
        return link;
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
    public Boolean deleteById(Integer id) {
        return null;
    }

    @Override
    public Optional<Link> findById(Integer id) {
        Optional<Link> linkReturn = this.links.stream().filter(link -> link.getId() == id).findFirst();

        if (linkReturn.isPresent()) {
            return linkReturn;
        }

        throw new NotFoundLinkException("Link not found");
    }

    @Override
    public ArrayList<Link> findAll() {
        return null;
    }
}
