package com.jpa.integrador.exception;

import com.jpa.integrador.dto.SuccessDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalHandler {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<SuccessDTO> notFound(NotFoundException e) {
        return ResponseEntity.ok(
                new SuccessDTO(
                        e.getMessage(),
                        HttpStatus.NOT_FOUND.value()
                )
        );
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<SuccessDTO> badRequest(BadRequestException e) {
        return ResponseEntity.ok(
                new SuccessDTO(
                        e.getMessage(),
                        HttpStatus.BAD_REQUEST.value()
                )
        );
    }
}
