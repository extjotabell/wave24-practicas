package com.socialmeli.SocialMeli.service.interfaces;

import com.socialmeli.SocialMeli.dto.CommentRequestDTO;
import com.socialmeli.SocialMeli.dto.CommentResponseDTO;
import com.socialmeli.SocialMeli.entity.Comment;
import com.socialmeli.SocialMeli.entity.Post;

import java.util.List;

public interface ICommentService {
    List<CommentResponseDTO> getCommentsByUser(Integer userId);
    CommentResponseDTO createComment(CommentRequestDTO commentDTO);
    CommentResponseDTO commentToDTO(Comment comment, Post post);
}
