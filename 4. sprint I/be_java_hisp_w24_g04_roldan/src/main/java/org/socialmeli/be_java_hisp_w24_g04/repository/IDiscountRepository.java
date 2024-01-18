package org.socialmeli.be_java_hisp_w24_g04.repository;

import org.socialmeli.be_java_hisp_w24_g04.model.Discount;

import java.util.Optional;

public interface IDiscountRepository extends ICrudRepository<Discount>{
    Optional<Discount> getDiscountByProductId(Integer productId);
}
