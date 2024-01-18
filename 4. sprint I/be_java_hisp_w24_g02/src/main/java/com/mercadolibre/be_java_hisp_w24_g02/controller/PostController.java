package com.mercadolibre.be_java_hisp_w24_g02.controller;

import com.mercadolibre.be_java_hisp_w24_g02.dto.CreatePostDTO;
import com.mercadolibre.be_java_hisp_w24_g02.dto.CreatePostDiscountDTO;
import com.mercadolibre.be_java_hisp_w24_g02.dto.PostDiscountDTO;
import com.mercadolibre.be_java_hisp_w24_g02.service.interfaces.IPostService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("products")
public class PostController {
    @Autowired
    private IPostService postService;

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

    @GetMapping("/promo-post/count")
    public ResponseEntity<PostDiscountDTO> getCountPromoPosts(@RequestParam(name = "user_id") Integer userId){
        return ResponseEntity.ok(this.postService.getCountPromoPosts(userId));
    }

    @PostMapping("/promo-post")
    public ResponseEntity<?> addNewProductPostDiscount(@Valid @RequestBody CreatePostDiscountDTO createPostDiscountDTO){
        this.postService.createProductPostDiscount(createPostDiscountDTO);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
