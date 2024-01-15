package org.example.ejexceptionhandler.blog.repository;

import org.example.ejexceptionhandler.blog.entity.EntradaBlog;

import java.util.Optional;

public interface IBlogRepository {
    Optional<EntradaBlog> findById(Long id);
}
