package org.example.linktracker.repository;

import org.example.linktracker.model.Link;

import java.util.List;

public interface ILinkRepository {
    List<Link> findAll();
    Link findById(Integer id);
    Link save(Link link);
}
