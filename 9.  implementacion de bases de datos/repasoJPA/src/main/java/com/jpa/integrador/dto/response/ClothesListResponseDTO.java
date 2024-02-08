package com.jpa.integrador.dto.response;

import java.util.List;

public record ClothesListResponseDTO (
        List<ClothesResponseDTO> clothes){
}
