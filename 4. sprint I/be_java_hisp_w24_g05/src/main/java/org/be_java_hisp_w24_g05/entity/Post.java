package org.be_java_hisp_w24_g05.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {

    private Integer postId;

    private Integer userId;

    private LocalDate date;

    private Product product;

    private Integer category;

    private Double price;

    private Boolean hasPromo;

    private Double discount;
}
