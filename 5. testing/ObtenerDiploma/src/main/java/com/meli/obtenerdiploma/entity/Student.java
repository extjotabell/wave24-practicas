package com.meli.obtenerdiploma.entity;

import com.meli.obtenerdiploma.dto.SubjectDTO;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Student {

    private Long id;

    private String studentName;

    private Set<Subject> subjects;

}
