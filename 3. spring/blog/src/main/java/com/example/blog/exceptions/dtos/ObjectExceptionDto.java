package com.example.blog.exceptions.dtos;


public class ObjectExceptionDto extends CustomExceptionDto{

    private final String objeto;

    public ObjectExceptionDto(String mensaje, int codigo, String objeto) {
        super(mensaje, codigo);
        this.objeto = objeto;
    }
}
