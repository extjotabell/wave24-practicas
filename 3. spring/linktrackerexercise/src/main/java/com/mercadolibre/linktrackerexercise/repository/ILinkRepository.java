package com.mercadolibre.linktrackerexercise.repository;

import com.mercadolibre.linktrackerexercise.entity.LinkEntity;

import java.util.List;
import java.util.Optional;

public interface ILinkRepository {
    public LinkEntity create(LinkEntity link);
    public Optional<LinkEntity> findByID(Integer id);

    public List<LinkEntity> findAll();

    public LinkEntity update(LinkEntity linkToUpdate);
}
