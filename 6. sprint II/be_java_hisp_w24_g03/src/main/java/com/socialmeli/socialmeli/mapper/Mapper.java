package com.socialmeli.socialmeli.mapper;

import com.socialmeli.socialmeli.dto.PostDto;
import com.socialmeli.socialmeli.dto.PostIdDto;
import com.socialmeli.socialmeli.dto.ProductDto;
import com.socialmeli.socialmeli.dto.UserDto;
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
        entity.setUserId(postDto.userId());
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
        product.setProductId(productDto.productId());
        product.setProductName(productDto.productName());
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
}
