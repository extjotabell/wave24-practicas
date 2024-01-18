package com.mercadolibre.be_java_hisp_w24_g02.service.interfaces;

import com.mercadolibre.be_java_hisp_w24_g02.dto.CreatePostDTO;
import com.mercadolibre.be_java_hisp_w24_g02.dto.CreatePostDiscountDTO;
import com.mercadolibre.be_java_hisp_w24_g02.dto.PostDiscountDTO;
import com.mercadolibre.be_java_hisp_w24_g02.entity.Post;

import java.util.List;

public interface IPostService {
    void createProductPost(CreatePostDTO createPostDTO);
    void createProductPostDiscount(CreatePostDiscountDTO createPostDiscountDTO);

    List<Post> getPosts();

    PostDiscountDTO getCountPromoPosts(Integer userId);
}
