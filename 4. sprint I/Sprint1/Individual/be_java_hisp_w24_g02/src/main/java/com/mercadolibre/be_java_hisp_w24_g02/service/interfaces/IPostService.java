package com.mercadolibre.be_java_hisp_w24_g02.service.interfaces;

import com.mercadolibre.be_java_hisp_w24_g02.dto.CreatePostDTO;
import com.mercadolibre.be_java_hisp_w24_g02.dto.PostBrandDTO;
import com.mercadolibre.be_java_hisp_w24_g02.dto.PostPromoCountDTO;

import java.util.List;

public interface IPostService {
    void createProductPost(CreatePostDTO createPostDTO);
    PostPromoCountDTO countProductsPromoUser(Integer userid);

    List<PostBrandDTO> postByBrands (String brand);
}
