package org.example.ejexceptionhandler.blog.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class EntradaBlog {

    private Long id;
    private String titulo;
    private String nombreDelAutor;
    private Date fechaDePublicacion;

}
