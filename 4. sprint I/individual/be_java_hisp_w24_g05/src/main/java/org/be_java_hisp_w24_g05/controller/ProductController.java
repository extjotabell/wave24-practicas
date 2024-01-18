package org.be_java_hisp_w24_g05.controller;

import org.be_java_hisp_w24_g05.dto.PostDto;
import org.be_java_hisp_w24_g05.dto.PromoPostDto;
import org.be_java_hisp_w24_g05.service.IPostService;
import org.be_java_hisp_w24_g05.service.IProductService;
import org.be_java_hisp_w24_g05.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private IProductService productService;
    @Autowired
    private IUserService userService;
    @Autowired
    private IPostService postService;

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<?> recentPostsOfFollowedUsers(@PathVariable int userId,@RequestParam(name = "order", defaultValue = "") String order){
        return ResponseEntity.ok(userService.recentPostsOfFollowedUsers(userId,order));
    }

    @PostMapping("/post")
    public ResponseEntity<?> makePost(@RequestBody PostDto p){
        return new ResponseEntity<>(productService.makePost(p), HttpStatus.OK);
    }
    @PostMapping("/promo-post")
    public ResponseEntity<?> makePromoPost(@RequestBody PromoPostDto p){

        return new ResponseEntity<>(productService.makePromoPost(p), HttpStatus.OK);
    }

    @GetMapping("/promo-post/count")
    public ResponseEntity<?> postOfUserWithDiscount(@RequestParam(name = "user_id") Integer userId){
        return ResponseEntity.ok(userService.searchUserPromoPosts(userId));
    }
    @GetMapping("/category/{category}/list")
    public ResponseEntity<?> searchPostsByCategory(@PathVariable Integer category,@RequestParam(name = "min_price", defaultValue = "") Double minPrice,
                                                   @RequestParam(name = "max_price", defaultValue = "") Double maxPrice,
                                                   @RequestParam(name = "order", defaultValue = "desc") String order){

            return ResponseEntity.ok(postService.searchPostsByCategory(category,minPrice,maxPrice,order));
        }

    @GetMapping("/category/{category}/list/{userId}")
    public ResponseEntity<?> searchPostsByCategoryAndUserId(@PathVariable Integer category,@PathVariable Integer userId,@RequestParam(name = "min_price", defaultValue = "") Double minPrice,
                                                   @RequestParam(name = "max_price", defaultValue = "") Double maxPrice,
                                                   @RequestParam(name = "order", defaultValue = "") String order){

            return ResponseEntity.ok(postService.searchPostsByCategoryAndUserId(category,userId,minPrice,maxPrice,order));
        }
    }