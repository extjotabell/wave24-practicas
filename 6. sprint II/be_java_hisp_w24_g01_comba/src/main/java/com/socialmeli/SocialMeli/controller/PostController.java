package com.socialmeli.SocialMeli.controller;

import com.socialmeli.SocialMeli.dto.responseDTO.LastestPostDTO;
import com.socialmeli.SocialMeli.dto.requestDTO.PostRequestDTO;
import com.socialmeli.SocialMeli.dto.responseDTO.PostResponseDTO;
import com.socialmeli.SocialMeli.service.interfaces.IPostService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class PostController {

    private final IPostService postService;

    public PostController(IPostService postService) {
        this.postService = postService;
    }

    @PostMapping("/post")
    public ResponseEntity<PostResponseDTO> createPost(@RequestBody @Valid PostRequestDTO postDTO) {
        return ResponseEntity.ok().body(postService.createPost(postDTO));
    }

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<LastestPostDTO> listPostUser(@PathVariable
                                                           @NotNull(message = "User id must not be empty")
                                                           @Min(value = 1, message = "User id must be greater than 0")Integer userId,
                                                       @RequestParam(required = false,defaultValue = "date_desc") String order){
        LastestPostDTO post = postService.getLatestPost(userId,order);
        return ResponseEntity.ok().body(post);
    }

}
