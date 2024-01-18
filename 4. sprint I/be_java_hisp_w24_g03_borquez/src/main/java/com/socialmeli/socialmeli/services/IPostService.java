package com.socialmeli.socialmeli.services;

import com.socialmeli.socialmeli.dto.*;

import java.util.List;

public interface IPostService {
    List<PostIdDto> getAllPosts();
    PostIdDto save(PostDto postDto);
    List<PostDto> getUserPosts(Integer userId);
    UserFollowedPostsDto getLastTwoWeeksFollowedPosts(Integer userId, List<UserDto> followedList, String order);

    PromoPostDto savePromoPost(PromoPostDto promoPostDto);

    PromoCountDto getTotalPromoProducts(Integer userId);
}
