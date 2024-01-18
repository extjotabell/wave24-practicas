package com.socialmeli.SocialMeli.service.interfaces;

import com.socialmeli.SocialMeli.dto.*;

public interface IPostService {
    PostResponseDTO createPost(PostRequestDTO postDTO);

    PostPromoResponseDTO createPromoPost(PostPromoRequestDTO postDTO);
    LastestPostDTO getLastestPost(Integer userId, String order);

    String checkOrder(String order);

    PostPromoCountResponseDTO getPromoCountByUserId(Integer userId);

}
