package com.socialmeli.SocialMeli.service.interfaces;

import com.socialmeli.SocialMeli.dto.*;

public interface IPostService {
    PostResponseDTO createPost(PostRequestDTO postDTO);
    LastestPostDTO getLastestPost(Integer userId, String order);
    String checkOrder(String order);

    void createPromoPost(PostPromoRequestDTO postDTO);

    PromoCountDTO countPostsPromo(Integer  id);
}
