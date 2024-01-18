package com.mercadolibre.be_java_hisp_w24_g02.controller;

import com.mercadolibre.be_java_hisp_w24_g02.dto.PromoPostAndUserInfoDTO;
import com.mercadolibre.be_java_hisp_w24_g02.dto.PromoPostQuantityDTO;
import com.mercadolibre.be_java_hisp_w24_g02.dto.PromoProductPostDTO;
import com.mercadolibre.be_java_hisp_w24_g02.service.interfaces.IPostService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products/promo-post")
public class PromoPostController {
    @Autowired
    private IPostService postService;

    /**
     * Create a new promo post
     * @param promoPost PromoProductPostDTO with the data of the post, annotation @Valid validate the data of the post
     * @return ResponseEntity with status 200 or 400 if the request is invalid
     */
    @PostMapping("")
    public ResponseEntity<?> createPromoPost(@Valid @RequestBody PromoProductPostDTO promoPost){
        this.postService.createPromoPost(promoPost);
        return ResponseEntity.ok().build();
    }

    /**
     * Get the quantity of promo posts by user id
     * @param userId Integer with the id of the user
     * @return ResponseEntity with status 200 or 400 if the request is invalid
     */
    @GetMapping("/count")
    public ResponseEntity<PromoPostQuantityDTO> getQuantityPromoPostByUserId(@RequestParam("user_id") Integer userId){
        return ResponseEntity.ok(this.postService.getPromoPostQuantityByUserId(userId));
    }

    /**
     * Get the promo posts by user id
     * @param userId Integer with the id of the user
     * @return ResponseEntity with status 200 or 400 if the request is invalid
     */
    @GetMapping("/list")
    public ResponseEntity<PromoPostAndUserInfoDTO> getPromoPostsByUser(@RequestParam("user_id") Integer userId){
        return ResponseEntity.ok(this.postService.getPromoPostsByUserId(userId));
    }

    /**
     * Download the promo posts by user id
     * @param response HttpServletResponse
     * @param userId Integer with the id of the user
     * @return void, a file is downloaded when the method is executed successfully
     */
    @GetMapping("/download-document/{userId}")
    public void downloadDocument(HttpServletResponse response, @NotNull(message = "userId is required") @PathVariable Integer userId){
        this.postService.downloadPromoPostsByUserId(response, userId);
    }
}
