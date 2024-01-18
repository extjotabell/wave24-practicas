package com.mercadolibre.be_java_hisp_w24_g02.repository.interfaces;

import com.mercadolibre.be_java_hisp_w24_g02.entity.Post;

import java.util.List;

public interface IPostRepository extends IDAORepository<Post> {

    List<Post> getPostOfFollowedList(List<Integer> userId);
    List<Post> findByUserId(Integer userId);

}
