package org.example.ejexceptionhandler.blog.service;

import org.example.ejexceptionhandler.blog.dto.EntradaBlogDTO;
import org.example.ejexceptionhandler.blog.entity.EntradaBlog;
import org.example.ejexceptionhandler.blog.exception.DuplicateElementException;
import org.example.ejexceptionhandler.blog.repository.IBlogRepository;
import org.springframework.stereotype.Service;

import javax.xml.stream.events.EntityReference;
import java.util.Optional;

@Service
public class BlogService {

    private final IBlogRepository blogRepository;

    public BlogService(IBlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    public Long postearEntradaBlog(EntradaBlogDTO entradaBlogDTO) {

        if(blogRepository.findById(entradaBlogDTO.id()).isPresent()){
            throw new DuplicateElementException("El elemento con id ", entradaBlogDTO.id(), " ya se encuentra cargado.");
        }

        return null;
    }
}
