package org.example.ejercicio.service;

import org.example.ejercicio.dto.EntradaBlogDTO;
import org.example.ejercicio.entity.EntradaBlog;
import org.example.ejercicio.exception.DataIntegrityViolationException;
import org.example.ejercicio.exception.NotFoundException;
import org.example.ejercicio.repository.IEntradaBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EntradaBlogService implements IEntradaBlogService{

    @Autowired
    private IEntradaBlogRepository entradaBlogRepository;


    @Override
    public Long saveEntradaBlog(EntradaBlog entradaBlog) {

        EntradaBlog entradaBlogSaved = entradaBlogRepository.save(entradaBlog);
        if(entradaBlogSaved == null) {
            throw new DataIntegrityViolationException("El blog con id: " + entradaBlog.getId() + " ya existe");
        }

        return entradaBlogSaved.getId();
    }

    @Override
    public EntradaBlogDTO findById(Long id) {

        EntradaBlog entradaBlog = entradaBlogRepository.findById(id);
        if(entradaBlog == null) {
            throw new NotFoundException("No se encontro el blog con el id: " + id);
        }

        return new EntradaBlogDTO(entradaBlog.getTitulo(), entradaBlog.getNombreAutor(), entradaBlog.getFechaPublicacion());
    }
}
