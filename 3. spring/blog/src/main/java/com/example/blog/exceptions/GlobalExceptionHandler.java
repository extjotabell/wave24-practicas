package com.example.blog.exceptions;

import com.example.blog.exceptions.customExceptions.NotFoundException;
import com.example.blog.exceptions.customExceptions.UnableToCreateException;
import com.example.blog.exceptions.dtos.CustomExceptionDto;
import com.example.blog.exceptions.dtos.ObjectExceptionDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ObjectExceptionDto> handleException(NotFoundException e){
        return ResponseEntity
                .status(e.getHttpStatus())
                .body(new ObjectExceptionDto(e.getMessage(), e.getCODE(), e.getObjeto()));
    }

    @ExceptionHandler(UnableToCreateException.class)
    public ResponseEntity<ObjectExceptionDto> handleException(UnableToCreateException e){
        return ResponseEntity
                .status(e.getHttpStatus())
                .body(new ObjectExceptionDto(e.getMessage(), e.getCODE(), e.getObjeto()));
    }

}
