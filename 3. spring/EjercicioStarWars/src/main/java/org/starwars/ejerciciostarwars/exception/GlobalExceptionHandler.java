package org.starwars.ejerciciostarwars.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.starwars.ejerciciostarwars.dto.exceptionsDtos.ExceptionDTO;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(EmptyListException.class)
    public ResponseEntity<ExceptionDTO> resolveEmptyListException(EmptyListException e) {
        return ResponseEntity.status(404).body(new ExceptionDTO(e.getCrudOperation(), 404, e.getMessage()));
    }
    @ExceptionHandler(EmptyParameterException.class)
    public ResponseEntity<ExceptionDTO> resolveEmptyParameterException(EmptyParameterException e) {
        return ResponseEntity.status(404).body(new ExceptionDTO(e.getCrudOperation(), 404, e.getMessage()));
    }
}
