package com.socialmeli.socialmeli.services;

import com.socialmeli.socialmeli.dto.PostDto;
import com.socialmeli.socialmeli.dto.PostIdDto;
import com.socialmeli.socialmeli.dto.UserDto;
import com.socialmeli.socialmeli.dto.UserFollowedPostsDto;

import java.util.List;

public interface IPostService {
    List<PostIdDto> getAllPosts();
    PostIdDto save(PostDto postDto);
    List<PostDto> getUserPosts(Integer userId);
    UserFollowedPostsDto getLastTwoWeeksFollowedPosts(Integer userId, List<UserDto> followedList, String order);
}
