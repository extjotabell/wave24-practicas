package org.mercadolibre.co.consigna.dto.exception;

public record ExceptionDTO (
         String timestamp,

         Integer status,

         String error,

         String message
) {
}
