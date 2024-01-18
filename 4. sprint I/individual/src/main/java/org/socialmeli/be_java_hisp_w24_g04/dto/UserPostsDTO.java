package org.socialmeli.be_java_hisp_w24_g04.dto;

import org.socialmeli.be_java_hisp_w24_g04.model.Post;

import java.util.List;

public record UserPostsDTO(Integer user_id, String user_name, List<Post> posts) {
}
