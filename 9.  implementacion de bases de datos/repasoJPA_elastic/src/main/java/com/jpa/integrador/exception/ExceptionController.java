package com.jpa.integrador.exception;

import com.jpa.integrador.dto.SuccessDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice(annotations = RestController.class)
public class ExceptionController {
    private ResponseEntity<SuccessDTO> globalErrorResponse(String msg, HttpStatus status) {
        return new ResponseEntity<>(new SuccessDTO(msg, status.value()), status);
    }

    @ExceptionHandler(DBConnectionException.class)
    public ResponseEntity<SuccessDTO> handleDBConnectionException(DBConnectionException e) {
        var status = HttpStatus.INTERNAL_SERVER_ERROR;

        return globalErrorResponse(e.getMessage(), status);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<SuccessDTO> handleNotFoundException(NotFoundException e) {
        var status = HttpStatus.NOT_FOUND;

        return globalErrorResponse(e.getMessage(), status);
    }
}
