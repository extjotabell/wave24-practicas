package com.exercise.rommannumeral.exception;

import com.exercise.rommannumeral.dto.ExceptionDTO;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<List<ExceptionDTO>> validationException(ConstraintViolationException e){
        List<ExceptionDTO> exceptions = e.getConstraintViolations().stream().map(constraintViolation -> {
            return new ExceptionDTO(constraintViolation.getPropertyPath().toString(), constraintViolation.getMessage());
        }).toList();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exceptions);
    }
}
