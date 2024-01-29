package com.socialmeli.socialmeli.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Post {
    private Integer userId;
    private Integer postId;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate date;
    private Product product;
    private Integer category;
    private Double price;
    private Boolean hasPromo;
    private Double discount;

    public Post(Integer userId, Integer postId, LocalDate date, Product product, Integer category, Double price) {
        this.userId = userId;
        this.postId = postId;
        this.date = date;
        this.product = product;
        this.category = category;
        this.price = price;
    }
}
