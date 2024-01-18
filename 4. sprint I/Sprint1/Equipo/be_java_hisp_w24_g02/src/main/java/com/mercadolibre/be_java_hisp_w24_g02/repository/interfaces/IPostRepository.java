package com.mercadolibre.be_java_hisp_w24_g02.repository.interfaces;

import com.mercadolibre.be_java_hisp_w24_g02.entity.Post;
import com.mercadolibre.be_java_hisp_w24_g02.repository.interfaces.IDAORepository;

import java.util.List;

public interface IPostRepository extends IDAORepository<Post> {

    List<Post> getPostOfFollowedList(List<Integer> userId);

}
