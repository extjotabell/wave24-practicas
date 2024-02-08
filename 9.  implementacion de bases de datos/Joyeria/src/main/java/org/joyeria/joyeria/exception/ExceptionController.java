package org.joyeria.joyeria.exception;

import org.joyeria.joyeria.dto.Response.ErrorResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@ControllerAdvice(annotations = RestController.class)
public class ExceptionController {
    private ResponseEntity<ErrorResponseDTO> globalErrorResponse(String message, HttpStatus status) {
        return new ResponseEntity<>(ErrorResponseDTO.buildErrorResponse(status, message), status);
    }

    private String errorListToStringList(List<String> array) {
        return String.join(" - ", array);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponseDTO> validationException(MethodArgumentNotValidException e){
        return ResponseEntity.badRequest().body(
                ErrorResponseDTO.buildErrorResponse(
                        HttpStatus.BAD_REQUEST,
                        "Se encontraron los siguientes errores en las validaciones: " +
                                errorListToStringList(
                                        e
                                                .getBindingResult()
                                                .getAllErrors()
                                                .stream()
                                                .map((error) -> {
                                                    String fieldName = ((FieldError) error).getField();
                                                    String errorMessage = error.getDefaultMessage();

                                                    return fieldName + ": " + errorMessage + ".";
                                                })
                                                .toList()
                                )
                )
        );
    }

    @ExceptionHandler(QueryParamException.class)
    public ResponseEntity<ErrorResponseDTO> queryParamException(QueryParamException e) {
        return globalErrorResponse(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorResponseDTO> notFoundException(NotFoundException e) {
        return globalErrorResponse(e.getMessage(), HttpStatus.NOT_FOUND);
    }
}
