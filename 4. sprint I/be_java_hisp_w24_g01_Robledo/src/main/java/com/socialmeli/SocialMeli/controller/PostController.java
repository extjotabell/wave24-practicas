package com.socialmeli.SocialMeli.controller;

import com.socialmeli.SocialMeli.dto.*;
import com.socialmeli.SocialMeli.exception.BadRequestException;
import com.socialmeli.SocialMeli.service.interfaces.IPostService;
import com.socialmeli.SocialMeli.service.interfaces.IUserService;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<PostResponseDTO> createPost(@RequestBody PostRequestDTO postDTO) {
        if(postDTO.user_id() <= 0 || postDTO.product().product_id() <= 0 || postDTO.category().category_id() <= 0) {
            throw new BadRequestException("Id's must be greater than 0");
        }
        return ResponseEntity.ok().body(postService.createPost(postDTO));
    }

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<LastestPostDTO> listPostUser(@PathVariable Integer userId, @RequestParam(required = false,defaultValue = "date_desc") String order){
        order = this.postService.checkOrder(order);
        LastestPostDTO post = postService.getLastestPost(userId,order);
        return ResponseEntity.ok().body(post);
    }

    @PostMapping("/promo-post")
    public ResponseEntity<PostPromoResponseDTO> createPromoPost(@RequestBody PostPromoRequestDTO postDTO) {
        if(postDTO.user_id() <= 0 || postDTO.product().product_id() <= 0 || postDTO.category().category_id() <= 0) {
            throw new BadRequestException("Id's must be greater than 0");
        }
        return ResponseEntity.ok().body(postService.createPromoPost(postDTO));
    }

    @GetMapping("/promo-post/count")
    public ResponseEntity<PostPromoCountResponseDTO> createPromoPost(@RequestParam("user_id") Integer userId) {
        return ResponseEntity.ok().body(postService.getPromoCountByUserId(userId));
    }

}
