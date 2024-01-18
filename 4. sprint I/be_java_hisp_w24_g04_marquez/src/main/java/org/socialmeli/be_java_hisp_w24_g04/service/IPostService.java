package org.socialmeli.be_java_hisp_w24_g04.service;

import org.socialmeli.be_java_hisp_w24_g04.dto.PostDTO;

import java.util.List;

import org.socialmeli.be_java_hisp_w24_g04.dto.UserPostDTO;
import org.socialmeli.be_java_hisp_w24_g04.dto.UserPromoPostCountDTO;
import org.socialmeli.be_java_hisp_w24_g04.dto.UserPromoPostDTO;

public interface IPostService {
    List<PostDTO> searchAllFollowedLastTwoWeeks(Integer userId, String order);
    UserPostDTO createUserPost(UserPostDTO userPost);
    UserPromoPostDTO createUserPromoPost(UserPromoPostDTO userPost);
    UserPromoPostCountDTO countUserPromoPost(Integer userId);
    List<PostDTO> findPromoPostCategory(Integer category, String order);
}
