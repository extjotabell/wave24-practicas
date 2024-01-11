package com.example.blog.exceptions.dtos;

import lombok.Data;

@Data
public class CustomExceptionDto{

    private final String mensaje;
    private final int codigo;

}
