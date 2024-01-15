package org.example.ejexceptionhandler.blog.controller;

import lombok.Getter;
import org.example.ejexceptionhandler.blog.dto.EntradaBlogDTO;
import org.example.ejexceptionhandler.blog.entity.EntradaBlog;
import org.example.ejexceptionhandler.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BlogController {
    private final BlogService blogService;

    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @PostMapping("/blog")
    public ResponseEntity<String> postearEntradaBlog(@RequestBody EntradaBlogDTO entradaBlogDTO) {

        Long idBlog = blogService.postearEntradaBlog(entradaBlogDTO);
        return ResponseEntity.ok("Se ha creado con éxito el blog" + idBlog);
    }

}
