package com.socialmeli.SocialMeli.service.implementations;

import com.socialmeli.SocialMeli.dto.CommentRequestDTO;
import com.socialmeli.SocialMeli.dto.CommentResponseDTO;
import com.socialmeli.SocialMeli.entity.Comment;
import com.socialmeli.SocialMeli.entity.Post;
import com.socialmeli.SocialMeli.repository.interfaces.*;
import com.socialmeli.SocialMeli.service.interfaces.ICommentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService implements ICommentService {

    private final ICommentRepository commentRepository;
    private final IPostRepository postRepository;

    public CommentService(ICommentRepository commentRepository, IPostRepository postRepository){
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
    }

    @Override
    public List<CommentResponseDTO> getCommentsByUser(Integer userId) {
        //Get the list of comments of the user
        List<Comment> comments = commentRepository.findByUserId(userId);
        //To list of dto
        List<CommentResponseDTO> commentsDTO = comments.stream().map(comment -> {
            Post post = postRepository.findByIdPost(comment.getPostId());
            return this.commentToDTO(comment, post);
        }).toList();
        return commentsDTO;
    }

    @Override
    public CommentResponseDTO createComment(CommentRequestDTO commentDTO) {
        Integer id = commentRepository.findLastId() + 1;
        //Create new dto with current id
        CommentRequestDTO newCommentDTO = new CommentRequestDTO(id, commentDTO.comment_user_id(), commentDTO.comment_post_id(),commentDTO.comment_text());
        Comment comment = commentRepository.findByIdOrCreate(newCommentDTO);
        //Get the post with the given id
        Post post = postRepository.findByIdPost(comment.getPostId());
        return new CommentResponseDTO(comment.getId(), comment.getUserId(), post, comment.getCommentaryText()
        );
    }

    @Override
    public CommentResponseDTO commentToDTO(Comment comment, Post post) {
        return new CommentResponseDTO(comment.getId(), comment.getUserId(), post, comment.getCommentaryText());
    }

}
