package org.example.ejercicioempleados.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName = "employees")
public class Employee {
    @Id
    private String id;
    private String name;
    private String lastName;
    private Integer age;
    private String city;
    private String state;
}
