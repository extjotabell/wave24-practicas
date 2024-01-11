package org.linktraker.linktrackerapi.repository;

import org.linktraker.linktrackerapi.exception.ElementNotFoundException;
import org.linktraker.linktrackerapi.model.URI;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class URIRepository implements IURIRepository{
    private final List<URI> uris;

    public URIRepository() {
        this.uris = new ArrayList<>();
    }

    @Override
    public URI save(URI entity) {
        uris.add(entity);

        return null;
    }

    @Override
    public URI remove(Integer id) {
        var uriToRemove = uris.get(id);

        uris.remove(uriToRemove);

        return uriToRemove;
    }

    @Override
    public Optional<URI> findById(Integer id) {
        return uris.stream().filter(uri -> uri.getId().equals(id)).findFirst();
    }

    @Override
    public List<URI> findAll() {
        return this.uris;
    }

    @Override
    public URI update(URI entity) {
        var uriToUpdate = uris.stream().filter(uri -> uri.getId().equals(entity.getId())).findFirst().orElse(null);

        if (uriToUpdate == null) {
            throw new ElementNotFoundException("URL to update does not exist.");
        }

        var uriId = uris.indexOf(uriToUpdate);

        return uris.set(uriId, entity);
    }
}
