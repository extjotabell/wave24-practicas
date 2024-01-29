package com.socialmeli.SocialMeli.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Post {
    private Integer id;
    private Integer userId;
    @JsonFormat(pattern="dd-MM-yyyy")
    private LocalDate date;
    private Product product;
    private Category category;
    private Double price;
}

