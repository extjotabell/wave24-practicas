package com.bootcamp.dtoresponseentity.classes;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Person {
    private Long id;
    private String name;
    private String lastName;
    private Integer age;
    private List<Symptom> symptoms;
}
