package org.socialmeli.be_java_hisp_w24_g04.dto;

import org.socialmeli.be_java_hisp_w24_g04.model.Product;

public interface IUserPost {
    Integer getUser_id();
    String getDate();
    Product getProduct();
    Integer getCategory();
    Double getPrice();

}
