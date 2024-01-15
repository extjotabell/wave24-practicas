package org.example.ejexceptionhandler.blog.dto;

import java.util.Date;

public record EntradaBlogDTO(Long id, String titulo, String nombreDelAutor, Date fechaDePublicacion) {

    @Override
    public Long id() {
        return id;
    }

    @Override
    public String titulo() {
        return titulo;
    }

    @Override
    public String nombreDelAutor() {
        return nombreDelAutor;
    }

    @Override
    public Date fechaDePublicacion() {
        return fechaDePublicacion;
    }
}
