package com.socialmeli.SocialMeli.dto;

import com.socialmeli.SocialMeli.entity.Post;

//Redundant, its the same as commentrequest, should be deleted.
public record CommentResponseDTO (
        Integer comment_id,
        Integer comment_user_id,
        Post    comment_post,
        String  comment_text
){
}