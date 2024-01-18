package org.socialmeli.be_java_hisp_w24_g04.controller;

import org.socialmeli.be_java_hisp_w24_g04.dto.PromoResponseDTO;
import org.socialmeli.be_java_hisp_w24_g04.dto.SingleResponseDTO;
import org.socialmeli.be_java_hisp_w24_g04.dto.UserPostDTO;
import org.socialmeli.be_java_hisp_w24_g04.service.IDiscountService;
import org.socialmeli.be_java_hisp_w24_g04.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final IPostService postService;
    private final IDiscountService discountService;

    @Autowired
    public ProductController(IPostService postService, IDiscountService discountService) {
        this.postService = postService;
        this.discountService = discountService;
    }

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<?> searchAllFollowedLastTwoWeeks(
            @PathVariable Integer userId,
            @RequestParam(required = false) String order
    ) {
        return new ResponseEntity<>(postService.searchAllFollowedLastTwoWeeks(userId, order), HttpStatus.OK);
    }

    @PostMapping("/post")
    public ResponseEntity<SingleResponseDTO> createUserPost(@RequestBody UserPostDTO userPost) {
        return ResponseEntity.ok(
                new SingleResponseDTO(200, postService.createUserPost(userPost))
        );
    }

    @GetMapping("/post/{product_name}")
    public ResponseEntity<SingleResponseDTO> getPostByProductName(@PathVariable("product_name") String productName) {
        return ResponseEntity.ok(
                new SingleResponseDTO(200, postService.getPostByProductName(productName))
        );
    }

    @PostMapping("/promo-post")
    public ResponseEntity<SingleResponseDTO> createUserPost(@RequestBody PromoResponseDTO createPromo) {
        return ResponseEntity.ok(
                new SingleResponseDTO(200, discountService.saveDiscount(createPromo))
        );
    }

    @GetMapping("/promo-post/range")
    public ResponseEntity<SingleResponseDTO> getDiscountsByLowAndHigh(
            @RequestParam("low_price") Double lowPrice,
            @RequestParam("high_price") Double highPrice,
            @RequestParam(value = "only_promos", required = false) Boolean onlyPromos
    ) {
        return ResponseEntity.ok(
                new SingleResponseDTO(
                        200,
                        discountService.getDiscountsBetweenPrices(
                                highPrice,
                                lowPrice,
                                onlyPromos != null ? onlyPromos : false
                        )
                )
        );
    }

    @GetMapping("/promo-post/discount-price")
    public ResponseEntity<SingleResponseDTO> getDiscountsWithDiscountPrice() {
        return ResponseEntity.ok(
                new SingleResponseDTO(200, discountService.getDiscountsWithDiscountPrice())
        );
    }

    @GetMapping("/promo-post/count")
    public ResponseEntity<SingleResponseDTO> getDiscountsByUserId(@RequestParam("user_id") Integer userId) {
        return ResponseEntity.ok(
                new SingleResponseDTO(200, discountService.getDiscountsByUserId(userId))
        );
    }
}
