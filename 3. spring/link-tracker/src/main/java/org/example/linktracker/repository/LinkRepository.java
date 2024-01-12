package org.example.linktracker.repository;

import org.example.linktracker.model.Link;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class LinkRepository implements ILinkRepository {

    private final List<Link> links = new ArrayList<>();
    private Integer nextId = 1;

    @Override
    public List<Link> findAll() {
        return links;
    }

    @Override
    public Link findById(Integer id) {
        return links.stream()
                .filter(link -> link.getLinkId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Link save(Link link) {
        link.setLinkId(nextId++);
        links.add(link);
        return link;
    }
}
