package com.example.blog.services.implementations;

import com.example.blog.dtos.EntradaBlogDTO;
import com.example.blog.entities.EntradaBlog;
import com.example.blog.exceptions.customExceptions.NotFoundException;
import com.example.blog.repositories.implementations.BlogRepository;
import com.example.blog.services.interfaces.BlogServiceInt;
import com.example.blog.utils.UserAction;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BlogServiceImp implements BlogServiceInt {

    private final BlogRepository blogRepository;

    @Override
    public EntradaBlogDTO getEntrada(Long id) {
        EntradaBlog entradaBlog = blogRepository.findById(id);

        if(entradaBlog == null){
            throw new NotFoundException("Entrada no encontrada", UserAction.GET, EntradaBlog.class);
        }

        return new EntradaBlogDTO(
                entradaBlog.getId(),
                entradaBlog.getTitulo(),
                entradaBlog.getNombreAutor(),
                entradaBlog.getFechaPublicacion()
        );
    }

    @Override
    public EntradaBlogDTO createEntrada(EntradaBlogDTO entradaBlog) {
        EntradaBlog entradaBlog1 = new EntradaBlog(entradaBlog);
        entradaBlog1 = blogRepository.save(entradaBlog1);

        return new EntradaBlogDTO(
                entradaBlog1.getId(),
                entradaBlog1.getTitulo(),
                entradaBlog1.getNombreAutor(),
                entradaBlog1.getFechaPublicacion()
        );
    }

    @Override
    public List<EntradaBlogDTO> getEntradas() {
        return blogRepository.findAll().stream()
                .map(entradaBlog -> new EntradaBlogDTO(
                        entradaBlog.getId(),
                        entradaBlog.getTitulo(),
                        entradaBlog.getNombreAutor(),
                        entradaBlog.getFechaPublicacion()
                ))
                .toList();
    }
}
