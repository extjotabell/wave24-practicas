package com.socialmeli.SocialMeli.entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Comment {
    Integer id;
    String commentaryText;
    Integer userId;
    Integer postId;
}
