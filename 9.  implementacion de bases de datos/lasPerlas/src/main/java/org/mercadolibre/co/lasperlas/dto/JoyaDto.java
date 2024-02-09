package org.mercadolibre.co.lasperlas.dto;

public record JoyaDto(

        String nombre,

        String material,

        Double peso,

        String particularidad,

        boolean poseePiedra,

        boolean ventaONo
) {
}
