package org.mercadolibre.co.lasperlas.exception;


import org.mercadolibre.co.lasperlas.dto.ExceptionDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ExceptionDto> notFoundException(NotFoundException e){
        return ResponseEntity.status(404).body(new ExceptionDto(e.getMessage(), "404", "Not Found", "/jewerly"));
    }

}
