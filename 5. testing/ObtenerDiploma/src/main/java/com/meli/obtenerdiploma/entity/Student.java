package com.meli.obtenerdiploma.entity;

import com.meli.obtenerdiploma.dto.SubjectDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    private Long id;

    private String studentName;

    private Set<Subject> subjects;
}
