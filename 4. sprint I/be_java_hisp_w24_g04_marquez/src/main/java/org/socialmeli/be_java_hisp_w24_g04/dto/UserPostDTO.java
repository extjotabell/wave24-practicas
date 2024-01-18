package org.socialmeli.be_java_hisp_w24_g04.dto;

import org.socialmeli.be_java_hisp_w24_g04.model.Product;

import java.time.LocalDate;

public record UserPostDTO(
        Integer user_id,
        String date,
        Product product,
        Integer category,
        Double price
) implements IUserPost {
    @Override
    public Integer getUser_id() {
        return this.user_id;
    }

    @Override
    public String getDate() {
        return this.date;
    }

    @Override
    public Product getProduct() {
        return this.product;
    }

    @Override
    public Integer getCategory() {
        return this.category;
    }

    @Override
    public Double getPrice() {
        return this.price;
    }
}
