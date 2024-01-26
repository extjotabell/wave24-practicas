package org.be_java_hisp_w24_g05.service;

import org.be_java_hisp_w24_g05.dto.PostDto;
import org.be_java_hisp_w24_g05.dto.ProductDto;
import org.be_java_hisp_w24_g05.entity.Post;
import org.be_java_hisp_w24_g05.entity.Product;
import org.be_java_hisp_w24_g05.exception.BadRequestException;
import org.be_java_hisp_w24_g05.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

@Service
public class ProductService implements IProductService {

    @Autowired
    private IUserRepository userRepository;

    @Override
    public PostDto makePost(PostDto p) {
        ProductDto pDto = p.product();
        if (Objects.isNull(pDto.productId()) || Objects.isNull(pDto.productName())) throw new BadRequestException("Product ID and Name can't be empty");
        Product product = new Product(pDto.productId(), pDto.productName(), pDto.type(), pDto.brand(), pDto.color(), pDto.notes());
        LocalDate date = LocalDate.parse(p.date(), DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        userRepository.addPost(new Post(0, p.userId(), date, product, p.category(), p.price()));
        return p;
    }

}
