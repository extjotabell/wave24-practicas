package org.linktracker.ejerciciolinktracker.repository;

import org.linktracker.ejerciciolinktracker.entity.Link;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface ILinkRepository {
    List<Link> findAll();
    Link findById(Integer id);
    Link save(Link link);
}
