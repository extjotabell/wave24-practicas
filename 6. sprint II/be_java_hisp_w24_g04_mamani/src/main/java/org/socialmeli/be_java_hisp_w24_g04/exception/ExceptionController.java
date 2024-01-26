package org.socialmeli.be_java_hisp_w24_g04.exception;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.socialmeli.be_java_hisp_w24_g04.dto.ErrorResponseDTO;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    private String errorListToStringList(List<String> array) {
        return String.join(" - ", array);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponseDTO> validationException(MethodArgumentNotValidException e){
        return ResponseEntity.badRequest().body(
                new ErrorResponseDTO(
                        400,
                        "Se encontraron los siguientes errores en las validaciones: " +
                                errorListToStringList(
                                        e
                                            .getAllErrors()
                                            .stream()
                                            .map(DefaultMessageSourceResolvable::getDefaultMessage)
                                            .toList()
                                )
                )
        );
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorResponseDTO> validationException(ConstraintViolationException e){
        return ResponseEntity.badRequest().body(
                new ErrorResponseDTO(
                        400,
                        "Se encontraron los siguientes errores en las validaciones: " +
                                errorListToStringList(
                                        e
                                                .getConstraintViolations()
                                                .stream()
                                                .map(ConstraintViolation::getMessage)
                                                .toList()
                                )

                )
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
