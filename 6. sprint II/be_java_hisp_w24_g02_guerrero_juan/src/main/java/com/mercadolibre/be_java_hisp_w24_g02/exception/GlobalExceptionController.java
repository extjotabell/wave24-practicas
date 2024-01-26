package com.mercadolibre.be_java_hisp_w24_g02.exception;

import com.mercadolibre.be_java_hisp_w24_g02.dto.ExceptionDTO;
import com.mercadolibre.be_java_hisp_w24_g02.dto.FieldExceptionDTO;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@ControllerAdvice(annotations = RestController.class)
public class GlobalExceptionController {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ExceptionDTO> notFound(Exception e){
        ExceptionDTO exceptionDAO = new ExceptionDTO(e.getMessage());
        return new ResponseEntity<>(exceptionDAO, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ExceptionDTO> badRequest(BadRequestException e){
        ExceptionDTO exceptionDAO = new ExceptionDTO(e.getMessage());
        return new ResponseEntity<>(exceptionDAO, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<FieldExceptionDTO>> handleValidationErrors(MethodArgumentNotValidException ex) {
        List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
        List<FieldExceptionDTO> exceptions = fieldErrors.stream().map(fieldError ->
                new FieldExceptionDTO(fieldError.getDefaultMessage(), fieldError.getField(), fieldError.getCode())
        ).toList();
        return ResponseEntity.badRequest().body(exceptions);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<List<ExceptionDTO>> validationException(ConstraintViolationException e){
        List<ExceptionDTO> exceptions = e.getConstraintViolations().stream().map(constraintViolation -> {
            return new ExceptionDTO(constraintViolation.getMessage());
        }).toList();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exceptions);
    }
}
