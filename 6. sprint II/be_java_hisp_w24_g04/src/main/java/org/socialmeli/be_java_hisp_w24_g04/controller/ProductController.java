package org.socialmeli.be_java_hisp_w24_g04.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import org.socialmeli.be_java_hisp_w24_g04.dto.SingleResponseDTO;
import org.socialmeli.be_java_hisp_w24_g04.dto.UserPostDTO;
import org.socialmeli.be_java_hisp_w24_g04.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/products")
@Validated
public class ProductController {

    private final IPostService postService;

    @Autowired
    public ProductController(IPostService postService) {
        this.postService = postService;
    }

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<?> searchAllFollowedLastTwoWeeks(
            @PathVariable
            @NotNull(message = "Parámetro user_id faltante (tipo Integer).")
            @PositiveOrZero(message = "El user_id debe ser mayor a cero.")
            Integer userId,
            @RequestParam(required = false) String order
    ) {
        return new ResponseEntity<>(postService.searchAllFollowedLastTwoWeeks(userId, order), HttpStatus.OK);
    }

    @PostMapping("/post")
    public ResponseEntity<SingleResponseDTO> createUserPost(@RequestBody @Valid UserPostDTO userPost) {
        return ResponseEntity.ok(
                new SingleResponseDTO(200, postService.createUserPost(userPost))
        );
    }
}
