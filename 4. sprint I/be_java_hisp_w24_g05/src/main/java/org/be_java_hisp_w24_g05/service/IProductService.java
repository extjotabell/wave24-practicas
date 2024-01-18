package org.be_java_hisp_w24_g05.service;


import org.be_java_hisp_w24_g05.dto.PostDto;
import org.be_java_hisp_w24_g05.dto.PromoPostDto;

public interface IProductService {
    PostDto makePost(PostDto post);
    PromoPostDto makePromoPost(PromoPostDto post);
}
