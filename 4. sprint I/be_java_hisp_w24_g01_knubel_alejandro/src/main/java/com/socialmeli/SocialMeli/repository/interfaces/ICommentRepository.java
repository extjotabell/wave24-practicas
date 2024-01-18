package com.socialmeli.SocialMeli.repository.interfaces;

import com.socialmeli.SocialMeli.dto.CategoryPostRequestDTO;
import com.socialmeli.SocialMeli.dto.CommentRequestDTO;
import com.socialmeli.SocialMeli.entity.Category;
import com.socialmeli.SocialMeli.entity.Comment;

import java.util.List;

public interface ICommentRepository extends ICrudRepository<Comment>{
    Comment findByIdOrCreate(CommentRequestDTO comment);

    //Encontrar los comentarios de un id de usuario
    List<Comment> findByUserId(Integer user_id);

    boolean commentExists(int category_id);

    Integer findLastId();
}
