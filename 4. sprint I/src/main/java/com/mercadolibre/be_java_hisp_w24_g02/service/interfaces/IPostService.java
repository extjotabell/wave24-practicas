package com.mercadolibre.be_java_hisp_w24_g02.service.interfaces;

import com.mercadolibre.be_java_hisp_w24_g02.dto.CreatePostDTO;
import com.mercadolibre.be_java_hisp_w24_g02.dto.PromoPostCountDTO;
import com.mercadolibre.be_java_hisp_w24_g02.dto.PromoPostDTO;
import com.mercadolibre.be_java_hisp_w24_g02.dto.UserFollowedsPostsDTO;

public interface IPostService {
    void createProductPost(CreatePostDTO createPostDTO);

    void createPromoPost(PromoPostDTO promoPostDTO);

    PromoPostCountDTO getPromosCount(Integer userId);

    void addPostToFavorites(Integer userId, Integer postId);

    void removePostToFavorites(Integer userId, Integer postId);

    UserFollowedsPostsDTO getUserFavorites(Integer userId, Integer postId);

    UserFollowedsPostsDTO getFollowedPost(Integer userId, String order);
}
