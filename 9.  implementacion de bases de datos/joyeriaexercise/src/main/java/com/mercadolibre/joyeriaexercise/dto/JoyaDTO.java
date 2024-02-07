package com.mercadolibre.joyeriaexercise.dto;

public record JoyaDTO(
        Long nroIdentificatorio,
        String nombre,
        String material,
        Double peso,
        String particularidad,
        Boolean poseePiedra,
        Boolean ventaONo
) {}
