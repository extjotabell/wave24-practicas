package com.socialmeli.SocialMeli.service.interfaces;

import com.socialmeli.SocialMeli.dto.*;

import java.util.List;

public interface IPostService {
    PostResponseDTO createPost(PostRequestDTO postDTO);
    LastestPostDTO getLastestPost(Integer userId, String order);

    String checkOrder(String order);
    void createPromoPost(PostPromoRequestDTO postDTO);

    ResponseQuantityPostPromoDTO getQuantityPostsPromo(Integer id);
    List<PostPromoRequestDTO> deleteMyPostById(Integer userId, Integer postId);
}
