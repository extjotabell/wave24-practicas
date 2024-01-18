package com.socialmeli.SocialMeli.controller;

import com.socialmeli.SocialMeli.dto.CommentRequestDTO;
import com.socialmeli.SocialMeli.dto.CommentResponseDTO;
import com.socialmeli.SocialMeli.service.implementations.UserService;
import com.socialmeli.SocialMeli.service.interfaces.ICommentService;
import com.socialmeli.SocialMeli.service.interfaces.IUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentController {
    private final ICommentService commentService;

    public CommentController(ICommentService commentService){
        this.commentService = commentService;
    }

    //Get a list of comments made by a user
    //GET: comments/list?user_id={userId}
    @GetMapping("/list")
    public ResponseEntity<List<CommentResponseDTO>> getCommentsByUser(@RequestParam Integer user_id) {
        return ResponseEntity.ok().body(commentService.getCommentsByUser(user_id));
    }

    //Create a new comment
    //POST: comments/new
    @PostMapping("/new")
    public ResponseEntity<CommentResponseDTO> createComment(@RequestBody CommentRequestDTO commentDTO) {
        return ResponseEntity.ok().body(commentService.createComment(commentDTO));
    }

}
