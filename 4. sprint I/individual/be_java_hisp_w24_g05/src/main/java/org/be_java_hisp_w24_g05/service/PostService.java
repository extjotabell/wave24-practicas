package org.be_java_hisp_w24_g05.service;

import org.be_java_hisp_w24_g05.dto.*;
import org.be_java_hisp_w24_g05.entity.Post;
import org.be_java_hisp_w24_g05.entity.Product;
import org.be_java_hisp_w24_g05.entity.User;
import org.be_java_hisp_w24_g05.exception.NotFoundException;
import org.be_java_hisp_w24_g05.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;


@Service
public class PostService implements IPostService {

    @Autowired
    private IUserRepository userRepository;


    @Override
    public List<PostDto> searchPostsByCategory(Integer category,Double minPrice, Double maxPrice, String order) {

        List<Post> posts = userRepository.findAll().stream().map(User::getPosts).flatMap(List::stream).toList();
        if(posts.isEmpty()){
            throw new NotFoundException("No posts found.");
        }
        List<PostDto> postDtos= listFilters(posts,category,minPrice,maxPrice,order);
        if(postDtos.isEmpty()){
            throw new NotFoundException("No posts found for category " + category+" with this filters");
        }
        return postDtos;
    }

    @Override
    public List<PostDto> searchPostsByCategoryAndUserId(Integer category, Integer userId, Double minPrice, Double maxPrice, String order) {
        List<Post> posts = userRepository.findById(userId).get().getFollowed().stream().map(User::getPosts).flatMap(List::stream).toList();
        if(posts.isEmpty()){
            throw new NotFoundException("No posts found.");
        }
        List<PostDto> postDtos= listFilters(posts,category,minPrice,maxPrice,order);
        if(postDtos.isEmpty()){
            throw new NotFoundException("No posts found for category " + category+" with this filters");
        }
        return postDtos;
    }
    public List<PostDto> listFilters(List<Post> posts,Integer category, Double minPrice, Double maxPrice, String order) {
        return posts.stream().filter(p-> Objects.equals(p.getCategory(), category)).
                filter(minPrice!=null?p->p.getPrice()>=minPrice:p->true).
                filter(maxPrice!=null?p->p.getPrice()<=maxPrice:p->true).
                sorted(order.equals("asc")?Comparator.comparing(Post::getDate):Comparator.comparing(Post::getDate).reversed()).
                map(this::postToPostDTO).toList();
    }
    public PostDto postToPostDTO(Post post) {
        return new PostDto(
                post.getUserId(),
                post.getDate().toString(),
                productToProductDTO(post.getProduct()),
                post.getCategory(),
                post.getPrice()
        );
    }
    public ProductDto productToProductDTO(Product product) {
        return new ProductDto(
                product.getProductId(),
                product.getProductName(),
                product.getType(),
                product.getBrand(),
                product.getColor(),
                product.getNote()
        );
    }
}
