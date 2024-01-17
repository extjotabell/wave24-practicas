package com.mercadolibre.be_java_hisp_w24_g02.service.implementations;

import com.mercadolibre.be_java_hisp_w24_g02.dto.CreatePostDTO;
import com.mercadolibre.be_java_hisp_w24_g02.dto.PostPromoCountDTO;
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

import java.util.List;
import java.util.Optional;
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

    @Override
    public PostPromoCountDTO CountProductsPromoUser(Integer userid) {
        List<Post> postUser= this.postRepository.findAll().stream().filter(p->p.getUserId().equals(userid) && p.getHasPromo()).toList();
        String name = userRepository.findById(userid).get().getName();
        if (name == null || name.isEmpty()){
            throw new NotFoundException("Not found the user with this " +userid + ".");
        }
        Integer count = postUser.size();

        return new PostPromoCountDTO(
        userid,name,count
        );
    }

    /**
     * Transform a CreatePostDTO to a Post entity
     * @param postDAO
     * @return Post entity
     */
    private Post transformCreatePostDAOToPostEntity(CreatePostDTO postDAO){
        Integer id = this.postRepository.findAll().size();
        Boolean hasPromo = postDAO.hasPromo() != null ? postDAO.hasPromo() : false;
        Double discount = postDAO.discount() != null ? postDAO.discount() : 0.0;
        if (hasPromo && discount == 0.0) {
            throw new BadRequestException("Si tiene una promocion , el descuento no puede ser 0.0");
        }
        if (!hasPromo && discount != 0.0) {
            throw new BadRequestException("Si no tiene una promocion , el descuento debe ser 0.0");
        }
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
                hasPromo,
                discount
        );
    }
}
