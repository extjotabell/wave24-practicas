package org.be_java_hisp_w24_g05.service;

import org.be_java_hisp_w24_g05.dto.PostDto;
import org.be_java_hisp_w24_g05.dto.PostPromoDto;
import org.be_java_hisp_w24_g05.dto.ProductDto;
import org.be_java_hisp_w24_g05.entity.Post;
import org.be_java_hisp_w24_g05.entity.Product;
import org.be_java_hisp_w24_g05.entity.User;
import org.be_java_hisp_w24_g05.repository.IPostRepository;
import org.be_java_hisp_w24_g05.repository.IProductRepository;
import org.be_java_hisp_w24_g05.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class ProductService implements IProductService {

    @Autowired
    private IUserRepository userRepository;

    @Override
    public PostDto makePost(PostDto p) {
        Product product = productDtoToProduct(p.product());
        LocalDate date = LocalDate.parse(p.date(), DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        userRepository.addPost(new Post(0, p.userId(), date, product, p.category(), p.price(), false, 0D));
        return p;
    }

    @Override
    public PostPromoDto makePostPromo(PostPromoDto p) {
        Product product = productDtoToProduct(p.product());
        LocalDate date = LocalDate.parse(p.date(), DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        userRepository.addPost(new Post(0, p.userId(), date, product, p.category(), p.price(), p.hasPromo(), p.discount()));
        return p;
    }

    private Product productDtoToProduct(ProductDto pDto){
        return new Product(
                pDto.productId(),
                pDto.productName(),
                pDto.type(),
                pDto.brand(),
                pDto.color(),
                pDto.note());
    }

}
