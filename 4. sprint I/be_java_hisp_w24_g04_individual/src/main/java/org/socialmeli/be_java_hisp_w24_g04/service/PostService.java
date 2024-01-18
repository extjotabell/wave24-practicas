package org.socialmeli.be_java_hisp_w24_g04.service;

import org.socialmeli.be_java_hisp_w24_g04.dto.PostDTO;
import org.socialmeli.be_java_hisp_w24_g04.dto.PromoPostCountDTO;
import org.socialmeli.be_java_hisp_w24_g04.dto.PromoPostDTO;
import org.socialmeli.be_java_hisp_w24_g04.dto.UserPostDTO;
import org.socialmeli.be_java_hisp_w24_g04.exception.BadRequestException;
import org.socialmeli.be_java_hisp_w24_g04.exception.InvalidTimeException;
import org.socialmeli.be_java_hisp_w24_g04.exception.NotFoundException;
import org.socialmeli.be_java_hisp_w24_g04.model.Post;
import org.socialmeli.be_java_hisp_w24_g04.model.User;
import org.socialmeli.be_java_hisp_w24_g04.repository.IPostRepository;
import org.socialmeli.be_java_hisp_w24_g04.repository.IProductRepository;
import org.socialmeli.be_java_hisp_w24_g04.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;

@Service
public class PostService implements IPostService {
    private final IPostRepository postRepository;
    private final IUserRepository userRepository;
    private final IProductRepository productRepository;

    @Autowired
    public PostService(
            IPostRepository postRepository,
            IUserRepository userRepository,
            IProductRepository productRepository
    ) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
        this.productRepository = productRepository;
    }

    @Override
    public UserPostDTO createUserPost(UserPostDTO userPost) {
        var idFound = userRepository
                .findAll()
                .stream()
                .filter(user -> user.getUserId().equals(userPost.user_id()))
                .findFirst()
                .orElse(null);

        if (idFound == null)
            throw new BadRequestException("Couldn't create user's post. Please, try again with a valid" +
                    " user ID.");

        var posts = postRepository.findAll();
        var postId = 0;

        if (posts != null)
            postId = posts.size() + 1;

        LocalDate dt;
        DateTimeFormatter dateFormat;

        try {
            dateFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            dt = LocalDate.parse(userPost.date(), dateFormat);
        } catch (Exception e) {
            throw new InvalidTimeException("Invalid date format. It should be dd-MM-yyyy");
        }

        productRepository.save(userPost.product());
        postRepository.save(new Post(
                postId,
                userPost.user_id(),
                dt,
                userPost.product(),
                userPost.category(),
                userPost.price()
        ));

        return userPost;
    }

    @Override
    public PromoPostDTO createPromoPost(PromoPostDTO promoPostDTO) {

        Optional<User> foundUser = userRepository.get(promoPostDTO.user_id());

        if(foundUser.isEmpty())
            throw new NotFoundException("Couldn't create user's post. Please, try again with a valid user ID.");

        Integer postId = postRepository.findAll().size() + 1;

        LocalDate dt;

        try {
            DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            dt = LocalDate.parse(promoPostDTO.date(), dateFormat);
        } catch (Exception e) {
            throw new InvalidTimeException("Invalid date format. It should be dd-MM-yyyy");
        }

        if(promoPostDTO.has_promo() && promoPostDTO.discount() == 0.0
                || !promoPostDTO.has_promo() && promoPostDTO.discount() > 0.0
        )
            throw new BadRequestException("Couldn't create user's post. Please, try again with a valid discount.");

        productRepository.save(promoPostDTO.product());
        postRepository.save(new Post(
                postId,
                promoPostDTO.user_id(),
                dt,
                promoPostDTO.product(),
                promoPostDTO.category(),
                promoPostDTO.price(),
                promoPostDTO.has_promo(),
                promoPostDTO.discount()
        ));

        return new PromoPostDTO(
                promoPostDTO.user_id(),
                postId,
                promoPostDTO.date(),
                promoPostDTO.product(),
                promoPostDTO.category(),
                promoPostDTO.price(),
                promoPostDTO.has_promo(),
                promoPostDTO.discount());
    }

    @Override
    public PromoPostCountDTO getPromoPostCount(Integer userId) {

        Optional<User> foundUser = userRepository.get(userId);

        if(foundUser.isEmpty())
            throw new NotFoundException("User not found.");

        Integer promoPostCount = foundUser.get().getPosts().stream().filter(Post::getHasPromo).toList().size();

        return new PromoPostCountDTO(
                foundUser.get().getUserId(),
                foundUser.get().getUsername(),
                promoPostCount);

    }

    @Override
    public List<PromoPostDTO> searchPromoPosts(String brand, String type) {

        List<Post> posts = postRepository.findAll().stream().filter(Post::getHasPromo).toList();

        if(!Objects.isNull(brand) && !brand.isBlank()) {
            posts = posts.stream().filter(post -> post.getProduct().getBrand().equals(brand)).toList();
        }
        if(!Objects.isNull(type) && !type.isBlank()) {
            posts = posts.stream().filter(post -> post.getProduct().getType().equals(type)).toList();
        }

        return posts.stream().map(post -> new PromoPostDTO(
                post.getUserId(),
                post.getPostId(),
                post.getDate().toString(),
                post.getProduct(),
                post.getCategory(),
                post.getPrice(),
                post.getHasPromo(),
                post.getDiscount())).toList();
    }

    @Override
    public List<PostDTO> searchAllFollowedLastTwoWeeks(Integer userId, String order) {
        List<PostDTO> foundPosts = new ArrayList<>();
        LocalDate dateNow = LocalDate.now();
        var user = userRepository.get(userId);

        if (user.isEmpty())
            throw new NotFoundException("User not found.");

        try{
            user.get().getFollowed().forEach(followed -> {
                postRepository.findAll().stream().filter(post -> post.getUserId().equals(followed.user_id()) && (ChronoUnit.DAYS.between(post.getDate(),dateNow) <= 14)).forEach(post -> {
                    PostDTO postDTO = new PostDTO(
                            post.getUserId(),
                            post.getPostId(),
                            post.getDate().toString(),
                            post.getProduct(),
                            post.getCategory(),
                            post.getPrice()
                    );
                    foundPosts.add(postDTO);
                });
            });
        } catch (Exception e) {
            throw new NotFoundException("User not found");
        }

        if (order != null)
            if(order.equals("date_asc")) {
                foundPosts.sort(Comparator.comparing(PostDTO::date));
            } else if (order.equals("date_desc")) {
                foundPosts.sort(Comparator.comparing(PostDTO::date).reversed());
            } else {
                throw new BadRequestException("Order must be date_asc or date_desc");
            }

        return foundPosts;
    }
}
