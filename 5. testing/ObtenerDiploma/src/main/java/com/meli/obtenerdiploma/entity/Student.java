package com.meli.obtenerdiploma.entity;

import lombok.*;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Student {

    private Long id;

    private String studentName;

    private Set<Subject> subjects;
}
