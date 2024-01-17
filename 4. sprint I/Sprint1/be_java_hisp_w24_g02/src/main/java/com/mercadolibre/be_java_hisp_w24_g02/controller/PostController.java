package com.mercadolibre.be_java_hisp_w24_g02.controller;

import com.mercadolibre.be_java_hisp_w24_g02.dto.CreatePostDTO;
import com.mercadolibre.be_java_hisp_w24_g02.entity.Post;
import com.mercadolibre.be_java_hisp_w24_g02.repository.implementations.PostRepositoryImpl;
import com.mercadolibre.be_java_hisp_w24_g02.service.interfaces.IPostService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("products")
public class PostController {
    @Autowired
    private IPostService postService;
    @Autowired
    private PostRepositoryImpl postRepository;

    /**
     * Add new product post
     * @param createPostDTO
     * @return ResponseEntity with status 200 or 400 if the request is invalid
     */
    @PostMapping("/post")
    public ResponseEntity<?> addNewProductPost(@Valid @RequestBody CreatePostDTO createPostDTO){
        this.postService.createProductPost(createPostDTO);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
    @PostMapping("/promo-post")
    public ResponseEntity<?>addNewPromoPost(@Valid @RequestBody CreatePostDTO createPostDTO){
        this.postService.createProductPost((createPostDTO));
        return ResponseEntity.status(HttpStatus.OK).build();
    }
    @GetMapping("/promo-post/count")
    public ResponseEntity<?>getPostPromoUser(@RequestParam(name = "user_id") Integer userId){
        return ResponseEntity.ok(postService.CountProductsPromoUser(userId));
    }
    @GetMapping("/allpost")
    public ResponseEntity<List<Post>>consultartodoslospost(){
        return ResponseEntity.ok(postRepository.findAll().stream().sorted(Comparator.comparingInt(Post::getPostId).reversed())
                .collect(Collectors.toList()));
    }
}
