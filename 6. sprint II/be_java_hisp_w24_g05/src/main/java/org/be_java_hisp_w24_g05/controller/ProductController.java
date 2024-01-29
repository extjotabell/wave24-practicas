package org.be_java_hisp_w24_g05.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.be_java_hisp_w24_g05.dto.PostDto;
import org.be_java_hisp_w24_g05.service.IProductService;
import org.be_java_hisp_w24_g05.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<?> recentPostsOfFollowedUsers(@PathVariable @Min(value = 1, message = "UserId tiene que ser mayor a cero") Integer userId, @RequestParam(name = "order", defaultValue = "") String order){
        return ResponseEntity.ok(userService.recentPostsOfFollowedUsers(userId,order));
    }

    @PostMapping("/post")
    public ResponseEntity<?> makePost(@RequestBody @Valid PostDto p){
        return new ResponseEntity<>(productService.makePost(p), HttpStatus.OK);
    }
}
