package com.socialmeli.SocialMeli.service.interfaces;

import com.socialmeli.SocialMeli.dto.*;

import java.util.List;

public interface IPostService {
    PostResponseDTO createPost(PostRequestDTO postDTO);
    LastestPostDTO getLastestPost(Integer userId, String order);

    String checkOrder(String order);

    ProductResponseDTO getPromoPostCount(Integer userId);

    List<PostWithIdDTO> searchPost(String category, Double price);
}
