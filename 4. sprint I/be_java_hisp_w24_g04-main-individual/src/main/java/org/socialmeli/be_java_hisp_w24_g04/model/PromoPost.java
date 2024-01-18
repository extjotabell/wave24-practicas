package org.socialmeli.be_java_hisp_w24_g04.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class PromoPost extends Post {
    @JsonProperty("has_promo")
    private Boolean hasPromo;
    private Double discount;

    public PromoPost(Integer postId, Integer userId, LocalDate date, Product product, Integer category, Double price,
                     Boolean hasPromo, Double discount) {
        super(postId, userId, date, product, category, price);
        this.hasPromo = hasPromo;
        this.discount = discount;
    }
}
