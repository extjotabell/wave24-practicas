package com.example.concesionaria.exception;

import com.example.concesionaria.dto.ExceptionDTO.ExceptionDtos;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.text.ParseException;


@ControllerAdvice  //todo lo que pasa con el controlaro se saca de aca anotacion para especificar la capa
public class GlobalExceptionHandler {

    @ExceptionHandler(ParseException.class)//majejador de excepciones
    public ResponseEntity<ExceptionDtos> ParseException(Exception e){
        return ResponseEntity.status(400).body(new ExceptionDtos(400, e.getMessage()));

    }
}
