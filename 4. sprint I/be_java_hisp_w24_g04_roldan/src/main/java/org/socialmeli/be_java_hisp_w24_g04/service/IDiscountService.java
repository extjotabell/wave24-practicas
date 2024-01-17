package org.socialmeli.be_java_hisp_w24_g04.service;

import org.socialmeli.be_java_hisp_w24_g04.dto.CreatePromoDTO;
import org.socialmeli.be_java_hisp_w24_g04.dto.UserDiscountsDTO;

public interface IDiscountService {
    public CreatePromoDTO saveDiscount(CreatePromoDTO createEntity);
    public UserDiscountsDTO getDiscountsByUserId(Integer userId);
}
