package org.be_java_hisp_w24_g05.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.be_java_hisp_w24_g05.dto.PostDto;
import org.be_java_hisp_w24_g05.dto.PostPromoDto;
import org.be_java_hisp_w24_g05.dto.ProductDto;
import org.be_java_hisp_w24_g05.entity.Post;
import org.be_java_hisp_w24_g05.entity.Product;
import org.be_java_hisp_w24_g05.entity.User;
import org.be_java_hisp_w24_g05.exception.BadRequestException;
import org.be_java_hisp_w24_g05.repository.IPostRepository;
import org.be_java_hisp_w24_g05.repository.IProductRepository;
import org.be_java_hisp_w24_g05.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.Validator;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class ProductService implements IProductService {

    @Autowired
    private IPostRepository postRepository;
    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private Validator validator;

    @Override
    public PostDto makePost(PostDto p) {
        ProductDto pDto = p.product();
        Product product = new Product(pDto.productId(), pDto.productName(), pDto.type(), pDto.brand(), pDto.color(), pDto.note());
        LocalDate date = LocalDate.parse(p.date(), DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        userRepository.addPost(new Post(0, p.userId(), date, product, p.category(), p.price()));
        return p;
    }

    @Override
    public PostPromoDto savePostPromo(PostPromoDto postPromoDto) {
        validate(postPromoDto);
        ProductDto pDto = postPromoDto.product();
        Product product = new Product(pDto.productId(), pDto.productName(), pDto.type(), pDto.brand(), pDto.color(), pDto.note());
        LocalDate date = LocalDate.parse(postPromoDto.date(), DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        userRepository.addPost(new Post(0, postPromoDto.userId(), date, product, postPromoDto.category(),
                postPromoDto.price(), postPromoDto.discount(), postPromoDto.hasPromo()));
        return postPromoDto;
    }

    private void validate(PostPromoDto postPromoDto) {
        Errors errors = new BeanPropertyBindingResult(postPromoDto, "postPromoDto");
        validator.validate(postPromoDto, errors);

        if (errors.hasErrors()) {
            StringBuilder errorMessage = new StringBuilder("Validation error: ");
            for (FieldError fieldError : errors.getFieldErrors()) {
                errorMessage.append(fieldError.getDefaultMessage()).append("; ");
            }
            throw new BadRequestException(errorMessage.toString());
        }
    }
}
