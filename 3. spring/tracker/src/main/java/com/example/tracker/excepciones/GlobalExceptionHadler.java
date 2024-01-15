package com.example.tracker.excepciones;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHadler {


    @ExceptionHandler(NoResourceFoundException.class)
    public ResponseEntity<String> NoResourceFoundException(Exception e){
        return ResponseEntity.badRequest().body("No hay registro");
    }

    @ExceptionHandler(EmptyArray.class)
    public ResponseEntity<String> EmptyArray(Exception e){
        return ResponseEntity.badRequest().body("No hay nada en la bd :(");
    }

}
