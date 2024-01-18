package org.socialmeli.be_java_hisp_w24_g04.dto;

import org.socialmeli.be_java_hisp_w24_g04.model.Post;
import org.socialmeli.be_java_hisp_w24_g04.model.Product;
import org.socialmeli.be_java_hisp_w24_g04.model.PromoPost;

import java.time.LocalDate;

public record PostDTO(
        Integer user_id,
        Integer post_id,
        String date,
        Product product,
        Integer category,
        Double price,
        Boolean has_promo,
        Double discount
) {
    public PostDTO(Integer userId, Integer postId, LocalDate date, Product product, Integer category, Double price) {
        this(
                userId,
                postId,
                date.toString(),
                product,
                category,
                price,
                false,
                0.0
        );
    }

    public PostDTO(Post post) {
        this(
                post.getUserId(),
                post.getPostId(),
                post.getDate(),
                post.getProduct(),
                post.getCategory(),
                post.getPrice()
        );
    }

    public PostDTO(PromoPost post) {
        this(
                post.getUserId(),
                post.getPostId(),
                post.getDate().toString(),
                post.getProduct(),
                post.getCategory(),
                post.getPrice(),
                post.getHasPromo(),
                post.getDiscount()
        );
    }
}
