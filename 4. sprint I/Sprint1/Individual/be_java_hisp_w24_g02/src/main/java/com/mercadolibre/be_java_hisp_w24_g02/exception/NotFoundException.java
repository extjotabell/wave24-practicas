package com.mercadolibre.be_java_hisp_w24_g02.exception;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String message) {
        super(message);
    }
}
