package org.be_java_hisp_w24_g05.service;

import org.be_java_hisp_w24_g05.entity.Post;
import org.be_java_hisp_w24_g05.repository.IPostRepository;
import org.be_java_hisp_w24_g05.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {

    @Autowired
    private IPostRepository postRepository;


}
