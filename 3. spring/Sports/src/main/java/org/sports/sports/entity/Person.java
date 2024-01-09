package org.sports.sports.entity;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Person {
    private String name;
    private String surname;
    private Integer age;
}
