package com.meli.obtenerdiploma.dto;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Set;


public record StudentDTO(

    Long id,

    String studentName,

    Set<SubjectDTO> subjects
){
}
