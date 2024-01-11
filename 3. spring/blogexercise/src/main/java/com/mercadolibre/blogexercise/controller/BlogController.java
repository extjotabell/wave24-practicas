package com.mercadolibre.blogexercise.controller;

import com.mercadolibre.blogexercise.dto.BlogDTO;
import com.mercadolibre.blogexercise.dto.CreateBlogDTO;
import com.mercadolibre.blogexercise.dto.CreateResponseDTO;
import com.mercadolibre.blogexercise.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("blogs")
public class BlogController {
    @Autowired
    private BlogService blogService;

    @PostMapping("/")
    public ResponseEntity<CreateResponseDTO> createBlog(@RequestBody CreateBlogDTO createBlogDTO){
        return ResponseEntity.ok(blogService.createBlog(createBlogDTO));
    }

    @GetMapping("/")
    public ResponseEntity<List<BlogDTO>> getAllBlogs(){
        return ResponseEntity.ok(blogService.findAllBlogs());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BlogDTO> getBlogById(@PathVariable Integer id){
        return ResponseEntity.ok(blogService.findBlogByID(id));
    }
}
