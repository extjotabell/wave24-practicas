package com.socialmeli.socialmeli.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private Integer productId;
    private String productName;
    private String type;
    private String brand;
    private String color;
    private String notes;
}
