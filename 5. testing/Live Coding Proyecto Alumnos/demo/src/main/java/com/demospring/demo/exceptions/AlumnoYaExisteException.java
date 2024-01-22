package com.demospring.demo.exceptions;

public class AlumnoYaExisteException extends RuntimeException{
    public AlumnoYaExisteException() {
    }

    public AlumnoYaExisteException(String message) {
        super(message);
    }
}
