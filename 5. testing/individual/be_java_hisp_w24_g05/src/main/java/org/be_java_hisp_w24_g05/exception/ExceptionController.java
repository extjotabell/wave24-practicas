package org.be_java_hisp_w24_g05.exception;


import org.be_java_hisp_w24_g05.dto.ErrorDto;
import org.be_java_hisp_w24_g05.dto.ExceptionDto;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.time.format.DateTimeParseException;
import java.util.stream.Collectors;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(value = {
            DateTimeParseException.class,
            BadRequestException.class,
            NotFoundException.class,
            NoResourceFoundException.class
    })
    public ResponseEntity<ExceptionDto> dniNotFound(RuntimeException e){
        return ResponseEntity.status(404)
                .body(
                        new ExceptionDto(
                                e.getMessage(),
                                e.getClass().getName(),
                                404
                        )
                );
    }

    @ExceptionHandler(value = {
            MethodArgumentNotValidException.class

    })
    public ResponseEntity<ErrorDto> MethodArgumentNotValidException(MethodArgumentNotValidException e){
        return ResponseEntity.badRequest().body(
                new ErrorDto("Se encontraron los siguientes errores en las validaciones: ",
                        e.getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.toList())
                )
        );
    }



}