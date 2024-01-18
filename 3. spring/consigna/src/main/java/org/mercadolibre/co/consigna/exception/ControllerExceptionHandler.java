package org.mercadolibre.co.consigna.exception;


import org.mercadolibre.co.consigna.dto.exception.ExceptionDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class ControllerExceptionHandler{

    @ExceptionHandler(InvalidUrlException.class)
    public ResponseEntity<ExceptionDTO> handleRuntimeException(RuntimeException exception){
        ExceptionDTO exceptionDTO = new ExceptionDTO(
                LocalDateTime.now().toString(),
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(),
                exception.getMessage()
        );
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exceptionDTO);
    }

    @ExceptionHandler(NotFoundLinkException.class)
    public ResponseEntity<ExceptionDTO> handleNotFoundLinkException(NotFoundLinkException exception){
        ExceptionDTO exceptionDTO = new ExceptionDTO(
                LocalDateTime.now().toString(),
                HttpStatus.NOT_FOUND.value(),
                HttpStatus.NOT_FOUND.getReasonPhrase(),
                exception.getMessage()
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exceptionDTO);
    }


}
