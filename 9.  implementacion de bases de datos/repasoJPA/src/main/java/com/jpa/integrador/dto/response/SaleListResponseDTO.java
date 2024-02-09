package com.jpa.integrador.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

public record SaleListResponseDTO ( List<SaleResponseDTO> sales){

}
