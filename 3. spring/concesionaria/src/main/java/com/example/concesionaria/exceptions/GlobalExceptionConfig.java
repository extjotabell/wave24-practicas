package com.example.concesionaria.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionConfig {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> notFoundException(NotFoundException e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

}
