package com.mercadolibre.be_java_hisp_w24_g02.service.interfaces;

import com.mercadolibre.be_java_hisp_w24_g02.dto.*;
import jakarta.servlet.http.HttpServletResponse;

public interface IPostService {
    void createProductPost(CreatePostDTO createPostDTO);
    void createPromoPost(PromoProductPostDTO createPostDTO);
    PromoPostQuantityDTO getPromoPostQuantityByUserId(Integer userId);
    PromoPostAndUserInfoDTO getPromoPostsByUserId(Integer userId);
    void downloadPromoPostsByUserId(HttpServletResponse res, Integer userId);
}
