package com.Link.link.exceptions;

import com.Link.link.dto.exceptions.ExceptionDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(InvalidUrlException.class)
    public ResponseEntity<ExceptionDTO> resolveInvalidUrlException(InvalidUrlException e){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body( new ExceptionDTO(e.getCrudOperation(),
                        LocalDateTime.now().toString(),
                        HttpStatus.INTERNAL_SERVER_ERROR.value(),
                        HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(),
                        e.getMessage()));
    }

    @ExceptionHandler(NotFoundLinkException.class)
    public ResponseEntity<ExceptionDTO> handleNotFoundLinkException(NotFoundLinkException e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body( new ExceptionDTO(e.getCrudOperation(),
                        LocalDateTime.now().toString(),
                        HttpStatus.NOT_FOUND.value(),
                        HttpStatus.NOT_FOUND.getReasonPhrase(),
                        e.getMessage()));
    }



}
