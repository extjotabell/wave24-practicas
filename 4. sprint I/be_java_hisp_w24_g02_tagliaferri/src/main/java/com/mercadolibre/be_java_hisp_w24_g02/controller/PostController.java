package com.mercadolibre.be_java_hisp_w24_g02.controller;

import com.mercadolibre.be_java_hisp_w24_g02.dto.*;
import com.mercadolibre.be_java_hisp_w24_g02.service.interfaces.IPostService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


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

    @PostMapping("/promo-post")
    public ResponseEntity<?> addNewPromoPost(@Valid @RequestBody CreatePromoPostDTO createPromoPostDTO){
        this.postService.createPromoPost(createPromoPostDTO);
        return ResponseEntity.status(HttpStatus.OK).build();
    }


    @GetMapping("/promo-post/count")
    public ResponseEntity<PromoPostCountUserDTO> countPromoPostUser(@RequestParam Integer user_id){
        PromoPostCountUserDTO promoPostCountUser = postService.getPromoPostCountUser(user_id);
        return ResponseEntity.ok(promoPostCountUser);
    }

    @GetMapping("/promo-post/{discount}/list")
    public ResponseEntity<List<PromoPostDTO>> listPromoPostByDiscount(@PathVariable Double discount){
        List<PromoPostDTO> PromoPostDiscounted = postService.getPromoPostByDiscount(discount);
        return ResponseEntity.ok(PromoPostDiscounted);
    }


}
