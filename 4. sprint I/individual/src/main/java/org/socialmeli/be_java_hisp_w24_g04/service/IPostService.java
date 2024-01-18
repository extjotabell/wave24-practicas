package org.socialmeli.be_java_hisp_w24_g04.service;

import org.socialmeli.be_java_hisp_w24_g04.dto.PostDTO;

import java.util.List;

import org.socialmeli.be_java_hisp_w24_g04.dto.ProductPostDTO;
import org.socialmeli.be_java_hisp_w24_g04.dto.UserPostDTO;
import org.socialmeli.be_java_hisp_w24_g04.model.Post;
import org.socialmeli.be_java_hisp_w24_g04.model.User;

public interface IPostService {
    List<PostDTO> searchAllFollowedLastTwoWeeks(Integer userId, String order);
    UserPostDTO createUserPost(UserPostDTO userPost);
    List<Post> addDiscountPost(ProductPostDTO post);
    Integer countDiscountProducts(User user);
    List<Post> getDiscountProducts(User user);
}
