package com.JPA.demo.entity.template;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientSummary {

    private Integer id;

    private String email;

    private String lastname;

    private String firstname;

    private Short age;

}
