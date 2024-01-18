package com.socialmeli.SocialMeli.dto;

public record CommentRequestDTO (
        Integer comment_id,
        Integer comment_user_id,
        Integer comment_post_id,
        String  comment_text
){
}
