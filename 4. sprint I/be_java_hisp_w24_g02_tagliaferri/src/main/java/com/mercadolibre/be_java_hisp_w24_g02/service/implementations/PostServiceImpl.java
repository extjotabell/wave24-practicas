package com.mercadolibre.be_java_hisp_w24_g02.service.implementations;

import com.mercadolibre.be_java_hisp_w24_g02.dto.CreatePostDTO;
import com.mercadolibre.be_java_hisp_w24_g02.dto.CreatePromoPostDTO;
import com.mercadolibre.be_java_hisp_w24_g02.dto.PromoPostCountUserDTO;
import com.mercadolibre.be_java_hisp_w24_g02.dto.UserFollowersCountDTO;
import com.mercadolibre.be_java_hisp_w24_g02.entity.Post;
import com.mercadolibre.be_java_hisp_w24_g02.entity.Product;
import com.mercadolibre.be_java_hisp_w24_g02.entity.User;
import com.mercadolibre.be_java_hisp_w24_g02.exception.NotFoundException;
import com.mercadolibre.be_java_hisp_w24_g02.repository.interfaces.IPostRepository;
import com.mercadolibre.be_java_hisp_w24_g02.repository.interfaces.IUserRepository;
import com.mercadolibre.be_java_hisp_w24_g02.service.interfaces.IPostService;
import com.mercadolibre.be_java_hisp_w24_g02.util.ValidateDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
     * Create a new promo product post
     * @param createPromoPostDTO
     * @throws NotFoundException if the user id not exists
     */
    @Override
    public void createPromoPost(CreatePromoPostDTO createPromoPostDTO) {
        if(this.userRepository.findById(createPromoPostDTO.userId()).isEmpty()){
            throw new NotFoundException("user id "+ createPromoPostDTO.userId() + " not found");
        }
        this.postRepository.save(this.transformCreatePromoPostDAOToPostEntity(createPromoPostDTO));
    }

    @Override
    public PromoPostCountUserDTO getPromoPostCountUser(Integer userId) {
        Optional<User> user = this.userRepository.findById(userId);
        if (user.isEmpty()){
            throw new NotFoundException("user id"+ userId + "not fount");
        }
        Integer promoPostCount = postRepository.findAll()
                .stream()
                .filter(post -> post.getUserId().equals(userId))
                .filter(Post::getHasPromo)
                .toList()
                .size();
        return new PromoPostCountUserDTO(userId, user.get().getName(), promoPostCount);
    }

    /**
     * Transform a CreatePostDTO to a Post entity
     * saves false on has promo and 0.0 on discount
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
                postDAO.price(),
                false,
                0.0
        );
    }

    /**
     * Transform a CreatePromoPostDTO to a Post entity
     * @param postDAO
     * @return Post entity
     */
    private Post transformCreatePromoPostDAOToPostEntity(CreatePromoPostDTO postDAO){
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
                postDAO.price(),
                postDAO.hasPromo(),
                postDAO.discount()
        );
    }
}
