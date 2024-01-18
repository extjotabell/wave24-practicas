package org.socialmeli.be_java_hisp_w24_g04.dto;

import org.socialmeli.be_java_hisp_w24_g04.model.Post;
import org.socialmeli.be_java_hisp_w24_g04.model.Product;
import org.socialmeli.be_java_hisp_w24_g04.model.PromoPost;

public record UserPostDTO(
        Integer user_id,
        String date,
        Product product,
        Integer category,
        Double price,
        Boolean has_promo,
        Double discount
) {
    public UserPostDTO(Post post) {
        this(
                post.getUserId(),
                post.getDate().toString(),
                post.getProduct(),
                post.getCategory(),
                post.getPrice(),
                false,
                0.0
        );
    }

    public UserPostDTO(PromoPost post) {
        this(
                post.getUserId(),
                post.getDate().toString(),
                post.getProduct(),
                post.getCategory(),
                post.getPrice(),
                post.getHasPromo(),
                post.getDiscount()
        );
    }
}
