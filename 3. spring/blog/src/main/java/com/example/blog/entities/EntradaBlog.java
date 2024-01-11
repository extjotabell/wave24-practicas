package com.example.blog.entities;

import com.example.blog.dtos.EntradaBlogDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EntradaBlog {

    private static Long contador = 5L;

    private Long id;
    private String titulo;
    private String nombreAutor;
    private LocalDate fechaPublicacion;

    public EntradaBlog(EntradaBlogDTO entradaBlogDTO){
        this.titulo = entradaBlogDTO.titulo();
        this.nombreAutor = entradaBlogDTO.nombreAutor();
        this.fechaPublicacion = entradaBlogDTO.fechaPublicacion();
    }

    public Long getNewContador(){
        return contador++;
    }

}
