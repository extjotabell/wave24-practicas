package org.be_java_hisp_w24_g05.controller;

import org.be_java_hisp_w24_g05.entity.Post;
import org.be_java_hisp_w24_g05.service.IProductService;
import org.be_java_hisp_w24_g05.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private IProductService productService;

    @Autowired
    private IUserService userService;

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<?> recentPostsOfFollowedUsers(@PathVariable int userId,@RequestParam(name = "order", defaultValue = "") String order){
        return ResponseEntity.ok(userService.recentPostsOfFollowedUsers(userId,order));
    }


    @PostMapping("/promo-post")
    public ResponseEntity<?> createPostWithPromo(@RequestBody Post post){
        return ResponseEntity.ok(userService.createPostWithPromo(post));
    }

    // aaaaaaaaaaaaaaahhhhhh lee bien la parte que NO tenes que hacer
    //igual sirve para testear
    @GetMapping("/promo-post/list/{userId}")
    public ResponseEntity<?> postsWithPromo(@PathVariable int userId){
        return ResponseEntity.ok(userService.postsWithPromo(userId));
    }

    //Cantidad de productos con promocion de un usuario
    @GetMapping("/promo-post/count")
    public ResponseEntity<?> countPromoPost(@RequestParam(name = "user_id") int userId){
        return ResponseEntity.ok(userService.countPromoPost(userId));
    }

}
