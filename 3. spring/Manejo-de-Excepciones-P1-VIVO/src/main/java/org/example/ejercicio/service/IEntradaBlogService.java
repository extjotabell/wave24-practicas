package org.example.ejercicio.service;

import org.example.ejercicio.dto.EntradaBlogDTO;
import org.example.ejercicio.entity.EntradaBlog;
import org.springframework.stereotype.Service;

public interface IEntradaBlogService {

    Long saveEntradaBlog(EntradaBlog entradaBlog);

    EntradaBlogDTO findById(Long id);
}
