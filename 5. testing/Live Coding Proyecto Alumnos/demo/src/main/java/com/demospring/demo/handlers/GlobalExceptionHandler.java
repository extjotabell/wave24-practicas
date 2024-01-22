package com.demospring.demo.handlers;

import com.demospring.demo.dto.ErrorDTO;
import com.demospring.demo.dto.ExceptionDTO;
import com.demospring.demo.exceptions.AlumnoYaExisteException;
import com.demospring.demo.exceptions.ListaVaciaException;
import com.demospring.demo.exceptions.IdNoEncontradoException;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = {
            IdNoEncontradoException.class,
            ListaVaciaException.class,
            AlumnoYaExisteException.class
    })
    public ResponseEntity<ExceptionDTO> dniNotFound(RuntimeException e){
            return ResponseEntity.status(404)
                    .body(
                            new ExceptionDTO(
                                    e.getMessage(),
                                    e.getClass().getName(),
                                    404
                            )
                    );
    }


    // AMBOS METODOS SIRVEN PARA CONVERTIR LOS MENSAJES DE LAS VALIDACIONES EN UN ARRAY DE MENSAJES ENTENDIBLES.

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorDTO> validationException(MethodArgumentNotValidException e){
        return ResponseEntity.badRequest().body(
                new ErrorDTO("Se encontraron los siguientes errores en las validaciones: ",
                        e.getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.toList())
                )
        );
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorDTO> validationException(ConstraintViolationException e){
        return ResponseEntity.badRequest().body(
                new ErrorDTO("Se encontraron los siguientes errores en las validaciones: ",
                        e.getConstraintViolations().stream().map(ConstraintViolation::getMessage).collect(Collectors.toList())
                )
        );
    }
}
