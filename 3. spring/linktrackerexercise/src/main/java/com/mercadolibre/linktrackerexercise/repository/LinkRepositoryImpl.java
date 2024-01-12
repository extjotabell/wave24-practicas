package com.mercadolibre.linktrackerexercise.repository;

import com.mercadolibre.linktrackerexercise.entity.LinkEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository
public class LinkRepositoryImpl implements ILinkRepository {
    private List<LinkEntity> links;

    public LinkRepositoryImpl() {
        this.links = new ArrayList<>();
    }

    @Override
    public LinkEntity create(LinkEntity link) {
        links.add(link);
        return link;
    }

    @Override
    public Optional<LinkEntity> findByID(Integer id) {
        return links.stream().filter(link -> Objects.equals(link.getId(), id)).findFirst();
    }

    @Override
    public List<LinkEntity> findAll() {
        return this.links;
    }

    @Override
    public LinkEntity update(LinkEntity linkToUpdate) {
        this.links = this.links.stream().map(link -> {
            if(Objects.equals(link.getId(), linkToUpdate.getId())){
                return linkToUpdate;
            }

            return link;
        }).toList();

        return linkToUpdate;
    }
}
