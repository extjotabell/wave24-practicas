package com.socialmeli.SocialMeli.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class PromoPost extends Post{
    private Boolean hasPromo;
    //These field is optional so it should be nullable
    private Double discount;

    public PromoPost(Integer id, Integer userId, LocalDate date, Product product, Category category, Double price, Boolean hasPromo, Double discount) {
        super(id, userId, date, product, category, price); // Call the superclass constructor
        this.hasPromo = hasPromo;
        this.discount = discount;
    }
}
