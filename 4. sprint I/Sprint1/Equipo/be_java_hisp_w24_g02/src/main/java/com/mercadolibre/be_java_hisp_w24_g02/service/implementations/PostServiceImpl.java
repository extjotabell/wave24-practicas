package com.mercadolibre.be_java_hisp_w24_g02.service.implementations;

import com.mercadolibre.be_java_hisp_w24_g02.dto.CreatePostDTO;
import com.mercadolibre.be_java_hisp_w24_g02.dto.PostDto;
import com.mercadolibre.be_java_hisp_w24_g02.dto.UserFollowedsPostsDTO;
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
        if (order.equals("date_asc")){
            return list.posts().stream().sorted(Comparator.comparing(PostDto::date)).toList();
        }
        return list.posts().stream().sorted(Comparator.comparing(PostDto::date).reversed()).toList();
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

}
