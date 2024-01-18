package com.socialmeli.SocialMeli.dto;

import com.socialmeli.SocialMeli.entity.Post;

import java.util.List;

public record UserPostsByPriceResponseDTO(Integer user_id, String user_name, List<Post> posts) {
}
