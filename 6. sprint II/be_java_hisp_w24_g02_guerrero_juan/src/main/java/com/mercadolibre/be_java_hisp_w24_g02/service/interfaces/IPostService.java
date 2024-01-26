package com.mercadolibre.be_java_hisp_w24_g02.service.interfaces;

import com.mercadolibre.be_java_hisp_w24_g02.dto.CreatePostDTO;
import com.mercadolibre.be_java_hisp_w24_g02.dto.UserFollowedsPostsDTO;
import com.mercadolibre.be_java_hisp_w24_g02.entity.Post;

import java.util.List;

public interface IPostService {
    void createProductPost(CreatePostDTO createPostDTO);


    UserFollowedsPostsDTO getFollowedPost(Integer userId, String order);


}
