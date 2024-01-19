package com.socialmeli.SocialMeli.service.interfaces;

import com.socialmeli.SocialMeli.dto.LastestPostDTO;
import com.socialmeli.SocialMeli.dto.PostRequestDTO;
import com.socialmeli.SocialMeli.dto.PostResponseDTO;

public interface IPostService {
    PostResponseDTO createPost(PostRequestDTO postDTO);
    LastestPostDTO getLastestPost(Integer userId, String order);

    String checkOrder(String order);
}
