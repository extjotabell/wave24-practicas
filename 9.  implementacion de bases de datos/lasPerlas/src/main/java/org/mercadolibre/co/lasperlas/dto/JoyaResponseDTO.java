package org.mercadolibre.co.lasperlas.dto;

public record JoyaResponseDTO(
        Long id,
        String nombre,
        String material,
        Double peso,
        String particularidad,
        boolean poseePiedra,
        boolean ventaONo

) {
}
