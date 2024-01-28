package com.socialmeli.SocialMeli.controller;

import com.socialmeli.SocialMeli.dto.*;
import com.socialmeli.SocialMeli.exception.BadRequestException;
import com.socialmeli.SocialMeli.service.interfaces.IPostService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@Validated
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

    //individual requirements
    @PostMapping("/promo-post")
    public ResponseEntity<PostResponseDTO> createPromoPost(@Valid @RequestBody PostRequestDTO postDTO) {
        return ResponseEntity.ok().body(postService.createPost(postDTO));


    }

    @GetMapping("/promo-post/count")
    public ResponseEntity<ProductResponseDTO> getPromoPostCount(@RequestParam  Integer user_id) {
        return ResponseEntity.ok().body(postService.getPromoPostCount(user_id));
    }

    //Bonus
    @GetMapping("/category/{category}/price/{price}")
    public ResponseEntity<List<PostWithIdDTO>> getPrice(@PathVariable String category, @PathVariable Double price) {
        return ResponseEntity.ok().body(postService.searchPost(category, price));
    }





}
