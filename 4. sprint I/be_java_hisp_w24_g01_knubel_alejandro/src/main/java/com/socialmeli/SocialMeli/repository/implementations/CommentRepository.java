package com.socialmeli.SocialMeli.repository.implementations;

import com.socialmeli.SocialMeli.dto.CommentRequestDTO;
import com.socialmeli.SocialMeli.dto.CommentResponseDTO;
import com.socialmeli.SocialMeli.entity.Comment;
import com.socialmeli.SocialMeli.exception.CommentNotFoundException;
import com.socialmeli.SocialMeli.repository.interfaces.ICommentRepository;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class CommentRepository implements ICommentRepository {

    private List<Comment> listComments = new ArrayList<Comment>();

    public CommentRepository() throws IOException {
    }


    @Override
    public Comment findByIdOrCreate(CommentRequestDTO commentDTO) {
        return this.findById(commentDTO.comment_id()).orElseGet(() -> this.create(
                new Comment(
                        commentDTO.comment_id(),
                        commentDTO.comment_text(),
                        commentDTO.comment_user_id(),
                        commentDTO.comment_post_id()
                )
        ));
    }

    //Encontrar los comentarios de un id de usuario
    @Override
    public List<Comment> findByUserId(Integer user_id) {
        List<Comment> comments = listComments.stream().filter(comment -> comment.getUserId().equals(user_id)).toList();
        if(comments.isEmpty()) throw new CommentNotFoundException("No se encontraron comentarios");
        return comments;
    }

    @Override
    public boolean commentExists(int category_id) {
        return false;
    }

    @Override
    public Comment create(Comment comment) {
        this.listComments.add(comment);
        return comment;
    }

    @Override
    public Boolean remove(Comment comment) {
        return null;
    }

    @Override
    public Optional<Comment> update(Comment comment) {
        return Optional.empty();
    }

    @Override
    public Optional<Comment> findById(Integer id) {
        return listComments.stream().filter(comment -> comment.getId().equals(id)).findFirst();
    }

    @Override
    public List<Comment> getAll() {
        return null;
    }

    @Override
    public Integer findLastId() {
        return listComments.stream().map(Comment::getId).max(Integer::compareTo).orElse(0);
    }
}
