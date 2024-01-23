package com.demospring.demo.entity;

import lombok.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Alumno {

    private String dni;

    private String name;

    private LocalDate birthDate;

    private Integer age;

    private List<Materia> materiasList;

}
