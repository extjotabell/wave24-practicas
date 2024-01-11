package com.mercadolibre.blogexercise.exception;

public class BadRequestException extends RuntimeException {
    public BadRequestException() {}

    public BadRequestException(String message) {
        super(message);
    }
}
