package org.be_java_hisp_w24_g05.service;


import org.be_java_hisp_w24_g05.dto.PostDto;
import org.be_java_hisp_w24_g05.dto.QuantityPromoByUserDto;

public interface IProductService {
    <T extends PostDto>T makePost(T post);
    QuantityPromoByUserDto countPromoOfUser(Integer userId);
}
