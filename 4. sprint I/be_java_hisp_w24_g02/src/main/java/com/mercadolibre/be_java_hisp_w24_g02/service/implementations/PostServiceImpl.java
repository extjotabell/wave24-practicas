package com.mercadolibre.be_java_hisp_w24_g02.service.implementations;

import com.mercadolibre.be_java_hisp_w24_g02.dto.*;
import com.mercadolibre.be_java_hisp_w24_g02.entity.Post;
import com.mercadolibre.be_java_hisp_w24_g02.entity.Product;
import com.mercadolibre.be_java_hisp_w24_g02.entity.User;
import com.mercadolibre.be_java_hisp_w24_g02.exception.DownloadDocException;
import com.mercadolibre.be_java_hisp_w24_g02.exception.NotFoundException;
import com.mercadolibre.be_java_hisp_w24_g02.repository.interfaces.IPostRepository;
import com.mercadolibre.be_java_hisp_w24_g02.repository.interfaces.IUserRepository;
import com.mercadolibre.be_java_hisp_w24_g02.service.interfaces.IPostService;
import com.mercadolibre.be_java_hisp_w24_g02.util.ValidateDate;
import com.opencsv.CSVWriter;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

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
     * Create a new promo post
     * @param createPostDTO
     * @throws NotFoundException if the user id not exists
     * return void
     */
    @Override
    public void createPromoPost(PromoProductPostDTO createPostDTO) {
        if(this.userRepository.findById(createPostDTO.userId()).isEmpty()){
            throw new NotFoundException("user id "+ createPostDTO.userId() + " not found");
        }
        this.postRepository.save(this.tranformCreatePromoPostDAOToPostEntity(createPostDTO));
    }

    /**
     * Get the quantity of promo posts by user id
     * @param userId
     * @throws NotFoundException if the user id not exists
     * @return PromoPostQuantityDTO
     */
    @Override
    public PromoPostQuantityDTO getPromoPostQuantityByUserId(Integer userId) {
        User userFinded = this.userRepository.findById(userId).orElseThrow(
                () -> new NotFoundException("User not found")
        );
        return new PromoPostQuantityDTO(
                userFinded.getId(),
                userFinded.getName(),
                this.postRepository.findByUserId(userId).stream().filter(Post::getHasPromo).toList().size()
        );
    }

    /**
     * Get the promo posts by user id
     * @param userId
     * @throws NotFoundException if the user id not exists
     * @return PromoPostAndUserInfoDTO
     */
    @Override
    public PromoPostAndUserInfoDTO getPromoPostsByUserId(Integer userId) {
        User userFinded = userRepository.findById(userId).orElseThrow(
                () -> new NotFoundException("User not found")
        );

        List<Post> promoPosts = this.postRepository.findByUserId(userId).stream().filter(Post::getHasPromo).toList();
        return this.transformEntityToPromoPostDTO(promoPosts, userFinded);
    }

    @Override
    public void downloadPromoPostsByUserId(HttpServletResponse res, Integer userId) {
        List<DownloadPromoPostDocDTO> promoPosts = this.postRepository.findByUserId(userId).stream()
                .filter(Post::getHasPromo)
                .map(post -> new DownloadPromoPostDocDTO(
                        post.getUserId(),
                        post.getDate().toString(),
                        post.getProduct().getProductId(),
                        post.getProduct().getProductName(),
                        post.getCategory(),
                        post.getPrice(),
                        post.getHasPromo(),
                        post.getDiscount()
                ))
                .toList();

        res.setContentType("text/csv");
        res.setHeader("Content-Disposition", "attachment; filename=\"promo_posts.csv\"");

        try(CSVWriter csvWriter = new CSVWriter(res.getWriter())){
            csvWriter.writeNext(new String[]{"user_id", "date", "product_id", "product_name", "category", "price", "has_promo", "discount"});
            promoPosts.forEach(post -> {
                csvWriter.writeNext(new String[]{post.userId().toString(), post.date(), post.productId().toString(), post.productName(), post.category().toString(), post.price().toString(), post.hasPromo().toString(), post.discount().toString()});
            });
        } catch (IOException e) {
            throw new DownloadDocException("Error downloading the file");
        }
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
                false, 0D
        );
    }

    /**
     * Transform a PromoProductPostDTO to a Post entity
     * @param postDAO
     * @return Post entity
     */
    private Post tranformCreatePromoPostDAOToPostEntity(PromoProductPostDTO postDAO){
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

    /**
     * Transform a Post entity and a User entity to a PromoPostAndUserInfoDTO
     * @param post List<Post>
     * @param user User
     * @return PromoPostAndUserInfoDTO
     */
    private PromoPostAndUserInfoDTO transformEntityToPromoPostDTO(List<Post> post, User user){
        return new PromoPostAndUserInfoDTO(
                user.getId(),
                user.getName(),
                post.stream().map(postCurr ->
                        new PromoProductPostDTO(
                                user.getId(),
                                postCurr.getDate().toString(),
                                new CreateProductDTO(
                                        postCurr.getProduct().getProductId(),
                                        postCurr.getProduct().getProductName(),
                                        postCurr.getProduct().getType(),
                                        postCurr.getProduct().getBrand(),
                                        postCurr.getProduct().getColor(),
                                        postCurr.getProduct().getNotes()
                                ),
                                postCurr.getCategory(),
                                postCurr.getPrice(),
                                postCurr.getHasPromo(),
                                postCurr.getDiscount()
                        )
                ).toList()
        );
    }
}
