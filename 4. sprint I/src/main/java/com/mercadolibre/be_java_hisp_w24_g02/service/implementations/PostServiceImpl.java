package com.mercadolibre.be_java_hisp_w24_g02.service.implementations;

import com.mercadolibre.be_java_hisp_w24_g02.dto.*;
import com.mercadolibre.be_java_hisp_w24_g02.entity.Post;
import com.mercadolibre.be_java_hisp_w24_g02.entity.Product;
import com.mercadolibre.be_java_hisp_w24_g02.entity.User;
import com.mercadolibre.be_java_hisp_w24_g02.exception.BadRequestException;
import com.mercadolibre.be_java_hisp_w24_g02.exception.NotFoundException;
import com.mercadolibre.be_java_hisp_w24_g02.repository.interfaces.IPostRepository;
import com.mercadolibre.be_java_hisp_w24_g02.repository.interfaces.IUserRepository;
import com.mercadolibre.be_java_hisp_w24_g02.service.interfaces.IPostService;
import com.mercadolibre.be_java_hisp_w24_g02.util.ValidateDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements IPostService {
    @Autowired
    private IPostRepository postRepository;
    @Autowired
    private IUserRepository userRepository;

    /**
     * Create a new product post
     * @param createPostDTO
     * @throws NotFoundException if the user id not exists
     */
    @Override
    public void createProductPost(CreatePostDTO createPostDTO) {
        if(this.userRepository.findById(createPostDTO.userId()).isEmpty()){
            throw new NotFoundException("user id "+ createPostDTO.userId() + " not found");
        }
        this.postRepository.save(this.transformCreatePostDAOToPostEntity(createPostDTO));
    }

    /**
     * Transform a CreatePostDTO to a Post entity
     * @param postDAO
     * @return Post entity
     */
    private Post transformCreatePostDAOToPostEntity(CreatePostDTO postDAO){
        Integer id = this.postRepository.findAll().size();
        return new Post(
                id,
                postDAO.userId(),
                ValidateDate.validateDateString(postDAO.date(), "dd-MM-yyyy"),
                new Product(
                        postDAO.product().productId(),
                        postDAO.product().productName(),
                        postDAO.product().type(),
                        postDAO.product().brand(),
                        postDAO.product().color(),
                        postDAO.product().notes()
                ),
                postDAO.category(),
                postDAO.price()
        );
    }

    @Override
    public void createPromoPost(PromoPostDTO promoPostDTO) {
        if(this.userRepository.findById(promoPostDTO.userId()).isEmpty()){
            throw new NotFoundException("user id "+ promoPostDTO.userId() + " not found");
        }
        this.postRepository.save(this.transformPromoPostDAOToPostEntity(promoPostDTO));
        System.out.println(this.postRepository.findAll());
    }

    @Override
    public PromoPostCountDTO getPromosCount(Integer userId) {
        User user = this.userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException("user id "+ userId + " not found"));

        long promoPostByUse = this.postRepository
                .findAll().stream()
                .filter(post -> post.getUserId().equals(userId) && post.getHasPromo())
                .count();

        int promoPostByUser = (int) promoPostByUse;

        return new PromoPostCountDTO(
                user.getId(),
                user.getName(),
                promoPostByUser
        );

    }

    @Override
    public void addPostToFavorites(Integer userId, Integer postId) {
        User user = this.userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException("user id "+ userId + " not found"));

        Post post = this.postRepository.findById(postId)
                .orElseThrow(() -> new NotFoundException("post id "+ postId + " not found"));

        user.getFavorites().add(post);
        this.userRepository.update(user);
    }

    @Override
    public void removePostToFavorites(Integer userId, Integer postId) {
        User user = this.userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException("user id "+ userId + " not found"));

        Post post = this.postRepository.findById(postId)
                .orElseThrow(() -> new NotFoundException("post id "+ postId + " not found"));

        user.getFavorites().remove(post);
        this.userRepository.update(user);
    }

    @Override
    public UserFollowedsPostsDTO getUserFavorites(Integer userId, Integer postId) {
        User user = this.userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException("user id "+ userId + " not found"));

        return new UserFollowedsPostsDTO(
                user.getId(),
                user.getFavorites().stream().map(this::convertPromoPostsDTO).toList()
        );
    }

    public UserFollowedsPostsDTO getFollowedPost(Integer userId){
        Optional<User> user = userRepository.findById(userId);
        if(user.isPresent()){
            List<Integer> getIdsFollowed = getIdsFollowed(user.get());
            List<Post> posts = postRepository.getPostOfFollowedList(getIdsFollowed);
            return new UserFollowedsPostsDTO(
                    user.get().getId(),
                    posts.stream().map(this::convertPostsDTO).toList()
            );
        }
        throw new NotFoundException("User not found");
    }

    public List<Integer> getIdsFollowed(User user) {
        return user.getFollowed().stream().map(User::getId).toList();
    }

    public UserFollowedsPostsDTO orderByDate(Integer userId, String order){
        UserFollowedsPostsDTO userFollowedsPostsDTO = getFollowedPost(userId);
        if(userId == null){
            throw new NotFoundException("User not found");
        }
        return new UserFollowedsPostsDTO(
                userFollowedsPostsDTO.userId(),
                orderListPost(userFollowedsPostsDTO, order)
        );
    }

    private List<PostDto> orderListPost(UserFollowedsPostsDTO list, String order){
        List<PostDto> dtoList = (List<PostDto>) list.posts();

        if (order.equals("date_asc")){
            return dtoList.stream().sorted(Comparator.comparing(PostDto::date)).toList();
        }
        return dtoList.stream().sorted(Comparator.comparing(PostDto::date).reversed()).toList();
    }

    private PostDto convertPostsDTO(Post posts){
        return new PostDto(posts.getPostId(),
                posts.getUserId(),
                posts.getDate(),
                posts.getProduct(),
                posts.getCategory(),
                posts.getPrice());
    }

    public UserFollowedsPostsDTO getFollowedPost(Integer userId, String order){
        if (order.equals("none")) {
            return getFollowedPost(userId);
        }
        if (order.equals("date_asc") || order.equals("date_desc")) {
            return orderByDate(userId, order);
        }
        throw new BadRequestException("Invalid order");
    }


    private PromoPostDTO convertPromoPostsDTO(Post post) {
        return new PromoPostDTO(
                post.getPostId(),
                post.getUserId(),
                post.getDate().toString(),
                new CreateProductDTO(
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
        );
    }

    private Post transformPromoPostDAOToPostEntity(PromoPostDTO promoPostDTO) {
        Integer id = this.postRepository.findAll().size();
        return new Post(
                id,
                promoPostDTO.userId(),
                ValidateDate.validateDateString(promoPostDTO.date(), "dd-MM-yyyy"),
                new Product(
                        promoPostDTO.product().productId(),
                        promoPostDTO.product().productName(),
                        promoPostDTO.product().type(),
                        promoPostDTO.product().brand(),
                        promoPostDTO.product().color(),
                        promoPostDTO.product().notes()
                ),
                promoPostDTO.category(),
                promoPostDTO.price(),
                promoPostDTO.hasPromo(),
                promoPostDTO.discount()
        );
    }

}
