package com.socialmeli.SocialMeli.service.interfaces;

import com.socialmeli.SocialMeli.dto.responseDTO.LastestPostDTO;
import com.socialmeli.SocialMeli.dto.requestDTO.PostRequestDTO;
import com.socialmeli.SocialMeli.dto.responseDTO.PostResponseDTO;

public interface IPostService {
    PostResponseDTO createPost(PostRequestDTO postDTO);
    LastestPostDTO getLatestPost(Integer userId, String orderRequest);

    String checkOrder(String order);
}
