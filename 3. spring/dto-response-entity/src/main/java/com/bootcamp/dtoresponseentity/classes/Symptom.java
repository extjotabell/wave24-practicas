package com.bootcamp.dtoresponseentity.classes;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Symptom {
    private Long code;
    private String name;
    private Integer severityLevel;
}
