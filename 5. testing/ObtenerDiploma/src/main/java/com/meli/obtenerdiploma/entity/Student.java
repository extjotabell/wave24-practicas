package com.meli.obtenerdiploma.entity;

import com.meli.obtenerdiploma.dto.SubjectDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Data //este ya lo tiene
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode //tema de espacio de memoria no sino a sus atributos
public class Student {

    private Long id;

    private String studentName;

    private Set<Subject> subjects;
}
