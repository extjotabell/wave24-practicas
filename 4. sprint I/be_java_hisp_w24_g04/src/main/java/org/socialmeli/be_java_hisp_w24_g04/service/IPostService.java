package org.socialmeli.be_java_hisp_w24_g04.service;

import org.socialmeli.be_java_hisp_w24_g04.dto.PostDTO;

import java.util.List;

import org.socialmeli.be_java_hisp_w24_g04.dto.PostPromoDTO;
import org.socialmeli.be_java_hisp_w24_g04.dto.UserPostDTO;
import org.socialmeli.be_java_hisp_w24_g04.dto.PostPromoCountDTO;

public interface IPostService {
    List<PostDTO> searchAllFollowedLastTwoWeeks(Integer userId, String order);
    UserPostDTO createUserPost(UserPostDTO userPost);
    PostPromoDTO createPromoPost(PostPromoDTO postPromoDTO);
    PostPromoCountDTO countPromoPosts(Integer userId);
}
