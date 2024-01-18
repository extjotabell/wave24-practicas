package org.socialmeli.be_java_hisp_w24_g04.service;

import org.socialmeli.be_java_hisp_w24_g04.dto.PromoResponseDTO;
import org.socialmeli.be_java_hisp_w24_g04.dto.PromoWithDiscountPriceDTO;
import org.socialmeli.be_java_hisp_w24_g04.dto.UserDiscountsDTO;

import java.util.List;

public interface IDiscountService {
    PromoResponseDTO saveDiscount(PromoResponseDTO createEntity);
    UserDiscountsDTO getDiscountsByUserId(Integer userId);
    List<PromoResponseDTO> getDiscountsBetweenPrices(Double highPrice, Double lowPrice, Boolean onlyPromos);
    List<PromoWithDiscountPriceDTO> getDiscountsWithDiscountPrice();
}
