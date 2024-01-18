package com.mercadolibre.be_java_hisp_w24_g02.service.implementations;

import com.mercadolibre.be_java_hisp_w24_g02.dto.CreatePostDTO;
import com.mercadolibre.be_java_hisp_w24_g02.dto.CreatePostDiscountDTO;
import com.mercadolibre.be_java_hisp_w24_g02.dto.PostDiscountDTO;
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

import java.util.List;

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

    @Override
    public void createProductPostDiscount(CreatePostDiscountDTO createPostDiscountDTO) {
        if(this.userRepository.findById(createPostDiscountDTO.userId()).isEmpty()){
            throw new NotFoundException("user id "+ createPostDiscountDTO.userId() + " not found");
        }
        this.postRepository.save(this.transformCreatePostDiscountDAOToPostEntity(createPostDiscountDTO));
    }

    @Override
    public List<Post> getPosts() {
        return postRepository.findAll();
    }

    @Override
    public PostDiscountDTO getCountPromoPosts(Integer userId) {
        User user = this.userRepository.findById(userId).orElseThrow(() -> new NotFoundException("user id "+ userId + " not found"));
        Integer countPromoPosts = Math.toIntExact(this.postRepository.findAll().stream()
                .filter(post -> post.getUserId().equals(userId) && post.getHasPromo())
                .count());
        return new PostDiscountDTO(user.getId(), user.getName(), countPromoPosts);
    }

    private Post transformCreatePostDiscountDAOToPostEntity(CreatePostDiscountDTO postDiscountDTO) {
        Integer id = this.postRepository.findAll().size();
        return new Post(
                id,
                postDiscountDTO.userId(),
                ValidateDate.validateDateString(postDiscountDTO.date(), "dd-MM-yyyy"),
                new Product(
                        postDiscountDTO.product().productId(),
                        postDiscountDTO.product().productName(),
                        postDiscountDTO.product().type(),
                        postDiscountDTO.product().brand(),
                        postDiscountDTO.product().color(),
                        postDiscountDTO.product().notes()
                ),
                postDiscountDTO.category(),
                postDiscountDTO.price(),
                postDiscountDTO.hasPromo(),
                postDiscountDTO.discount()
        );
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
                postDAO.price(),
                false,
                0.0
        );
    }
}
