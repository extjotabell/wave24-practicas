package com.mercadolibre.be_java_hisp_w24_g02.service.interfaces;

import com.mercadolibre.be_java_hisp_w24_g02.dto.CreatePostDTO;
import com.mercadolibre.be_java_hisp_w24_g02.dto.PromoPostCountDTO;
import com.mercadolibre.be_java_hisp_w24_g02.dto.PromoPostDTO;
import com.mercadolibre.be_java_hisp_w24_g02.dto.UserFollowedsPostsDTO;
import com.mercadolibre.be_java_hisp_w24_g02.entity.Post;

public interface IPostService {
    void createProductPost(CreatePostDTO createPostDTO);

    Post createPromoPost(PromoPostDTO promoPostDTO);

    PromoPostCountDTO getPromosCount(Integer userId);

    UserFollowedsPostsDTO getFollowedPost(Integer userId, String order);
}
