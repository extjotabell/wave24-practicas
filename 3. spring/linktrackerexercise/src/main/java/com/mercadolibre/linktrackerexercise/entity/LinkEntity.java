package com.mercadolibre.linktrackerexercise.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LinkEntity {
    private Integer id;
    private String url;
    private Integer quantityRedirections;
    private Boolean isValid;
}
