package com.practicas.linkTracker.exception;


import com.practicas.linkTracker.dto.ExceptionDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice(annotations = RestController.class)
public class GlobalExceptionHandler {
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ExceptionDTO> runtimeException(InvalidRequestException e) {
        return ResponseEntity.status(400).body(
                new ExceptionDTO(e.getMessage())
        );
    }

   @ExceptionHandler(InvalidRequestException.class)
   public ResponseEntity<ExceptionDTO> invalidRequest(InvalidRequestException e) {
       return ResponseEntity.status(400).body(
               new ExceptionDTO(e.getMessage())
       );
   }

    @ExceptionHandler(BadUrlException.class)
    public ResponseEntity<ExceptionDTO> badUrlException(BadUrlException e) {
        return ResponseEntity.status(404).body(
                new ExceptionDTO(e.getMessage())
        );
    }

    @ExceptionHandler(CrudException.class)
    public ResponseEntity<ExceptionDTO> crudException(CrudException e) {
        return ResponseEntity.status(500).body(
                new ExceptionDTO(e.getMessage())
        );
    }
}
