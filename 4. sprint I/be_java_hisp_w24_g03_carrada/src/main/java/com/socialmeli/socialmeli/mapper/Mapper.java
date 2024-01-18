package com.socialmeli.socialmeli.mapper;

import com.socialmeli.socialmeli.dto.*;
import com.socialmeli.socialmeli.entities.Post;
import com.socialmeli.socialmeli.entities.Product;
import com.socialmeli.socialmeli.entities.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class Mapper {

    public PostDto convertPostToDto(Post entity){
        return new PostDto(
                entity.getUserId(),
                entity.getDate(),
                convertProductToDto(entity.getProduct()),
                entity.getCategory(),
                entity.getPrice()
        );
    }

    public PostIdDto convertPostToDtoWithId(Post entity){
        return new PostIdDto(
                entity.getUserId(),
                entity.getPostId(),
                entity.getDate(),
                convertProductToDto(entity.getProduct()),
                entity.getCategory(),
                entity.getPrice()
        );
    }

    public Post convertDtoToPost(PostDto postDto){
        Post entity = new Post();
        entity.setUserId(postDto.user_id());
        entity.setDate(postDto.date());
        entity.setProduct(convertDtoToProduct(postDto.product()));
        entity.setCategory(postDto.category());
        entity.setPrice(postDto.price());
        return entity;
    }

    public ProductDto convertProductToDto(Product product){
        return new ProductDto(
                product.getProductId(),
                product.getProductName(),
                product.getType(),
                product.getBrand(),
                product.getColor(),
                product.getNotes()
        );
    }

    public Product convertDtoToProduct(ProductDto productDto){
        Product product = new Product();
        product.setProductId(productDto.product_id());
        product.setProductName(productDto.product_name());
        product.setType(productDto.type());
        product.setBrand(productDto.brand());
        product.setColor(productDto.color());
        product.setNotes(productDto.notes());
        return product;
    }
    public List<UserDto> convertToUserDtoList(List<User> users) {
        return users.stream()
                .map(this::convertToUserDto)
                .collect(Collectors.toList());
    }

    public UserDto convertToUserDto(User user) {
        return new UserDto(
                user.getUserId(),
                user.getUserName());
    }

    //Desarrollo Individual
    public Post convertDtoToPostPromo(PostPromoDto postPromoDto){
        Post post = new Post();
        post.setUserId(postPromoDto.user_id());
        post.setUserId(postPromoDto.user_id());
        post.setDate(postPromoDto.date());
        post.setProduct(convertDtoToProduct(postPromoDto.product()));
        post.setCategory(postPromoDto.category());
        post.setPrice(postPromoDto.price());
        post.setHasPromo(postPromoDto.has_promo());
        post.setDiscount(postPromoDto.discount());
        return post;
    }

    public PostPromoDto convertPromoPostToDto(Post post){
        return new PostPromoDto(
                post.getUserId(),
                post.getDate(),
                convertProductToDto(post.getProduct()),
                post.getCategory(),
                post.getPrice(),
                post.getHasPromo(),
                post.getDiscount()
        );
    }

    public List<PostPromoDto> convertToPostPromoDtoList(List<Post> userPosts) {
        return userPosts.stream()
                .map(post -> new PostPromoDto(
                        post.getUserId(),
                        post.getDate(),
                        new ProductDto(
                                post.getProduct().getProductId(),
                                post.getProduct().getProductName(),
                                post.getProduct().getType(),
                                post.getProduct().getBrand(),
                                post.getProduct().getColor(),
                                post.getProduct().getNotes()
                        ),
                        post.getCategory(),
                        post.getPrice(),
                        post.getHasPromo(),
                        post.getDiscount()
                ))
                .collect(Collectors.toList());
    }
}
