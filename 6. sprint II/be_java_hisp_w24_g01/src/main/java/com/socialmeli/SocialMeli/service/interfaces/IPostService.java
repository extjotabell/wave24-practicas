package com.socialmeli.SocialMeli.service.interfaces;

import com.socialmeli.SocialMeli.dto.responseDTO.LastestPostDTO;
import com.socialmeli.SocialMeli.dto.requestDTO.PostRequestDTO;
import com.socialmeli.SocialMeli.dto.responseDTO.PostResponseDTO;

public interface IPostService {
    PostResponseDTO createPost(PostRequestDTO postDTO);
    LastestPostDTO getLastestPost(Integer userId, String order);

    String checkOrder(String order);
}
