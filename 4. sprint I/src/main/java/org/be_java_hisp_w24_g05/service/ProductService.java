package org.be_java_hisp_w24_g05.service;

import org.be_java_hisp_w24_g05.dto.PostDto;
import org.be_java_hisp_w24_g05.dto.ProductDto;
import org.be_java_hisp_w24_g05.dto.PromoPostDto;
import org.be_java_hisp_w24_g05.dto.QuantityPromoByUserDto;
import org.be_java_hisp_w24_g05.entity.Post;
import org.be_java_hisp_w24_g05.entity.Product;
import org.be_java_hisp_w24_g05.entity.User;
import org.be_java_hisp_w24_g05.exception.BadRequestException;
import org.be_java_hisp_w24_g05.repository.IPostRepository;
import org.be_java_hisp_w24_g05.repository.IProductRepository;
import org.be_java_hisp_w24_g05.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ProductService implements IProductService {

    @Autowired
    private IPostRepository postRepository;
    @Autowired
    private IUserRepository userRepository;
    @Override
    public <T extends PostDto> T makePost(T post) {
        ProductDto pDto = post.getProduct();
        Product product = new Product(pDto.productId(), pDto.productName(), pDto.type(), pDto.brand(), pDto.color(), pDto.note());
        LocalDate date = LocalDate.parse(post.getDate(), DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        userRepository.addPost(new Post(
                0, post.getUserId(), date, product, post.getCategory(), post.getPrice(),
                post instanceof PromoPostDto,
                (post instanceof PromoPostDto) ? ((PromoPostDto) post).getDiscount():0.0
        ));
        return post;
    }
    @Override
    public QuantityPromoByUserDto countPromoOfUser(Integer userId) {
        Optional<User> user = userRepository.findById(userId);

        if(Objects.isNull(user)) throw new BadRequestException("User does not exists");
        Integer count = Math.toIntExact(user.get().getPosts().stream()
                .filter(post -> post.getHasPromo() != null && post.getHasPromo())
                .count());

        return new QuantityPromoByUserDto(userId, user.get().getUserName(),count) ;
    }




}
