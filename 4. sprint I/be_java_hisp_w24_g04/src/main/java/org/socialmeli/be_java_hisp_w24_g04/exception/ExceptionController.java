package org.socialmeli.be_java_hisp_w24_g04.exception;

import org.socialmeli.be_java_hisp_w24_g04.dto.ErrorResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;

@ControllerAdvice(annotations = RestController.class)
public class ExceptionController {
    private ResponseEntity<ErrorResponseDTO> globalErrorResponse(
            Integer statusCode,
            String message,
            HttpStatus status) {
        return new ResponseEntity<>(
                new ErrorResponseDTO(statusCode, message),
                status
        );
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ErrorResponseDTO> handleBadRequestException(BadRequestException e) {
        return globalErrorResponse(400, e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorResponseDTO> handleNotFoundException(NotFoundException e) {
        return globalErrorResponse(404, e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InvalidTimeException.class)
    public ResponseEntity<ErrorResponseDTO> handleInvalidTimeException(InvalidTimeException e) {
        return globalErrorResponse(400, e.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
