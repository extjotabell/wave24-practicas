package com.mercadolibre.be_java_hisp_w24_g02.service.interfaces;

import com.mercadolibre.be_java_hisp_w24_g02.dto.CreatePostDTO;
import com.mercadolibre.be_java_hisp_w24_g02.dto.CreatePromoPostDTO;
import com.mercadolibre.be_java_hisp_w24_g02.dto.PromoPostCountUserDTO;
import com.mercadolibre.be_java_hisp_w24_g02.dto.PromoPostDTO;

import java.util.List;

public interface IPostService {
    void createProductPost(CreatePostDTO createPostDTO);

    void createPromoPost(CreatePromoPostDTO createPromoPostDTO);
    PromoPostCountUserDTO getPromoPostCountUser(Integer userId);

    List<PromoPostDTO> getPromoPostByDiscount(Double discount);

}
