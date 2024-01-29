package com.socialmeli.SocialMeli.entity;

import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private Integer id;
    private String productName;
    private String type;
    private String brand;
    private String color;
    private String notes;
}
