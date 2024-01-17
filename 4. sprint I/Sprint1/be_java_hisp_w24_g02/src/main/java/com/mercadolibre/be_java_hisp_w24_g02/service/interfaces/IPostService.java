package com.mercadolibre.be_java_hisp_w24_g02.service.interfaces;

import com.mercadolibre.be_java_hisp_w24_g02.dto.CreatePostDTO;
import com.mercadolibre.be_java_hisp_w24_g02.dto.PostPromoCountDTO;

public interface IPostService {
    void createProductPost(CreatePostDTO createPostDTO);
    PostPromoCountDTO CountProductsPromoUser(Integer userid);
}
