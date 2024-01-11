package com.example.blog.services.interfaces;

import com.example.blog.dtos.EntradaBlogDTO;
import com.example.blog.entities.EntradaBlog;

import java.util.List;

public interface BlogServiceInt {

    EntradaBlogDTO getEntrada(Long id);

    EntradaBlogDTO createEntrada(EntradaBlogDTO entradaBlog);

    List<EntradaBlogDTO> getEntradas();

}
