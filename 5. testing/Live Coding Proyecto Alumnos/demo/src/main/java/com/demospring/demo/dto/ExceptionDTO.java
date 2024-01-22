package com.demospring.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public record ExceptionDTO(
    String message,
    String className,
    Integer status
    ){
}
