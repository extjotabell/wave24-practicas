package org.be_java_hisp_w24_g05.service;

import org.be_java_hisp_w24_g05.dto.PostDto;
import org.be_java_hisp_w24_g05.dto.ProductDto;
import org.be_java_hisp_w24_g05.dto.PromoPostDto;
import org.be_java_hisp_w24_g05.entity.Post;
import org.be_java_hisp_w24_g05.entity.Product;

import org.be_java_hisp_w24_g05.exception.BadRequestException;
import org.be_java_hisp_w24_g05.repository.IPostRepository;

import org.be_java_hisp_w24_g05.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


@Service
public class ProductService implements IProductService {

    @Autowired
    private IPostRepository postRepository;
    @Autowired
    private IUserRepository userRepository;

    @Override
    public PostDto makePost(PostDto p) {
        ProductDto pDto = p.product();
        Product product = new Product(pDto.productId(), pDto.productName(), pDto.type(), pDto.brand(), pDto.color(), pDto.note());
        LocalDate date = LocalDate.parse(p.date(), DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        userRepository.addPost(new Post(0, p.userId(), date, product, p.category(), p.price(),false,0.0 ));
        return p;
    }

    @Override
    public PromoPostDto makePromoPost(PromoPostDto p) {
        if(!validatePromoPost(p))
            throw new BadRequestException("los datos del descuento no son correctos.");

        ProductDto pDto = p.product();
        Product product = new Product(pDto.productId(), pDto.productName(), pDto.type(), pDto.brand(), pDto.color(), pDto.note());
        LocalDate date = LocalDate.parse(p.date(), DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        userRepository.addPost(new Post(0, p.userId(), date, product, p.category(), p.price(),p.hasPromo(),p.discount()));

        return p;
    }
    public boolean validatePromoPost(PromoPostDto p){
        return p.hasPromo() && p.discount() > 0 && p.discount() <= 1;
    }

}
