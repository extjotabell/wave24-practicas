package org.mercadolibre.co.consigna.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Link {

    private int id;

    private String url;

    private int cantidadLlamados;

    private String password;

}
