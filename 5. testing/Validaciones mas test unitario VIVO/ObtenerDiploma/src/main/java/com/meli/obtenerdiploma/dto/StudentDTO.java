package com.meli.obtenerdiploma.dto;



import java.util.Set;


public record StudentDTO(

    Long id,

    String studentName,

    Set< SubjectDTO> subjects
){
}
