package org.mercadolibre.co.lasperlas.dto;

public record ExceptionDto (
    String message,
    String code,
    String status,
    String path
){
}
