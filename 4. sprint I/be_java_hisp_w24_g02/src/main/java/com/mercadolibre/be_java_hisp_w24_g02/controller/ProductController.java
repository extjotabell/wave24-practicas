package com.mercadolibre.be_java_hisp_w24_g02.controller;

import com.mercadolibre.be_java_hisp_w24_g02.dto.UserFollowedsPostsDTO;
import com.mercadolibre.be_java_hisp_w24_g02.exception.BadRequestException;
import com.mercadolibre.be_java_hisp_w24_g02.service.implementations.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @Autowired
    private UserServiceImpl userService;

    /**
     * This method is used to get the followed posts of a user
     * @param userId the id of the user
     * @param order the order of the posts
     * @return a list of posts
     */
    @GetMapping("products/followed/{userId}/list")
    public ResponseEntity<UserFollowedsPostsDTO> getUserFollowed(@PathVariable Integer userId, @RequestParam(required = false, defaultValue = "none") String order) throws BadRequestException {
        UserFollowedsPostsDTO userServiceUserFollowed = userService.getFollowedPost(userId,order);
        return ResponseEntity.ok(userServiceUserFollowed);
    }


}
