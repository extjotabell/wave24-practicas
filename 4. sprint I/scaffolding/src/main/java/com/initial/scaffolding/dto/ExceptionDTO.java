package com.initial.scaffolding.dto;

import com.initial.scaffolding.util.CrudOperation;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public record ExceptionDTO(

        CrudOperation operation,

        LocalDateTime date,

        List<ExceptionCaseDTO> errors
) {
}
