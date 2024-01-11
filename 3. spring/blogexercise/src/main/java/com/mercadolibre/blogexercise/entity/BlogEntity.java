package com.mercadolibre.blogexercise.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class BlogEntity {
    private Integer id;
    private String title;
    private String authorName;
    private String publicationDate;
}
