package org.be_java_hisp_w24_g05.service;


import org.be_java_hisp_w24_g05.dto.PostDto;


import java.util.List;

public interface IPostService {
    List<PostDto> searchPostsByCategory(Integer category,Double minPrice, Double maxPrice, String order);
    List<PostDto> searchPostsByCategoryAndUserId(Integer category,Integer userId,Double minPrice, Double maxPrice, String order);
}
