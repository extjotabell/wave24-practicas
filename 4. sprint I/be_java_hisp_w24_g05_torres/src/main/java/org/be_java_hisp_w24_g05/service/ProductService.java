package org.be_java_hisp_w24_g05.service;

import org.be_java_hisp_w24_g05.dto.*;
import org.be_java_hisp_w24_g05.entity.*;
import org.be_java_hisp_w24_g05.exception.BadRequestException;
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
    private IPostRepository postRepository;
    @Autowired
    private IUserRepository userRepository;

    @Override
    public PostDto makePost(PostDto p) {
        ProductDto pDto = p.product();
        Product product = new Product(pDto.productId(), pDto.productName(), pDto.type(), pDto.brand(), pDto.color(), pDto.note());
        LocalDate date = LocalDate.parse(p.date(), DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        userRepository.addPost(new Post(0, p.userId(), date, product, p.category(), p.price()));
        return p;
    }

    @Override
    public PromoPostDto makePromoPost(PromoPostDto p) {
        ProductDto pDto = p.product();
        Product product = new Product(pDto.productId(), pDto.productName(), pDto.type(), pDto.brand(), pDto.color(), pDto.note());
        LocalDate date = LocalDate.parse(p.date(), DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        Post post = new Post(0, p.userId(), date, product, p.category(), p.price());
        userRepository.addPost(new PromoPost(post, p.discount(),p.hasPromo()));
        return p;
    }

    @Override
    public CountPromoPostDto countPromoPosts(int userId) {

        List<Post> promoPosts = userRepository.getPromoPostbyUserId(userId);

        User user = userRepository.findById(userId).get();


        return new CountPromoPostDto(
                userId,
                user.getUserName(),
                promoPosts.size()
        );
    }

    @Override
    public Object favoritePost(int postId, int userId) {
        User user = this.userRepository.findById(userId).get();
        Post post = this.postRepository.findById(postId).get();

        if(postRepository.getFavoritePost(postId,userId) != null){
            throw new BadRequestException("Post already favorited");
        }

        FavoritePost favoritePost = new FavoritePost(user.getUserId(), post.getPostId());

        postRepository.saveFavoritePost(favoritePost);

        return new FavoritePostDto(
                favoritePost.getUserId(),
                favoritePost.getPostId()
        );
    }

    @Override
    public Object listFavoritePosts(int userId) {

        List<Post> favoritePosts = postRepository.getFavoritePosts(userId);

        if(favoritePosts.isEmpty()){
            throw new BadRequestException("No favorite posts");
        }

        return favoritePosts.stream().map(post -> new PostDto(
               post.getUserId(),
                 post.getDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")),
                new ProductDto(
                        post.getProduct().getProductId(),
                        post.getProduct().getProductName(),
                        post.getProduct().getType(),
                        post.getProduct().getBrand(),
                        post.getProduct().getColor(),
                        post.getProduct().getNote()
                ),
                post.getCategory(),
                post.getPrice()
        )).toList();
    }

}
