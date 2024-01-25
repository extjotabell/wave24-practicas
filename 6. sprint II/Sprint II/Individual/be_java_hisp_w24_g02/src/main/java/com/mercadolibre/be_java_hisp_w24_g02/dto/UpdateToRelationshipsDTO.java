package com.mercadolibre.be_java_hisp_w24_g02.dto;


import jakarta.validation.constraints.Min;

public record UpdateToRelationshipsDTO(
        Integer userId,
        Integer userToUpdate
) {}
