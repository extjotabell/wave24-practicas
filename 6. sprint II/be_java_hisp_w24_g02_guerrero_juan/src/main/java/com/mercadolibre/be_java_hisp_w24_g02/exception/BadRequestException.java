package com.mercadolibre.be_java_hisp_w24_g02.exception;

public class BadRequestException extends RuntimeException {
    public BadRequestException(String message) {
        super(message);
    }
}
