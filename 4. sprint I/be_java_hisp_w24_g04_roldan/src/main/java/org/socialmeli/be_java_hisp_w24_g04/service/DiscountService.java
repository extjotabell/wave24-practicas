package org.socialmeli.be_java_hisp_w24_g04.service;

import org.socialmeli.be_java_hisp_w24_g04.dto.CreatePromoDTO;
import org.socialmeli.be_java_hisp_w24_g04.dto.UserDiscountsDTO;
import org.socialmeli.be_java_hisp_w24_g04.dto.UserPostDTO;
import org.socialmeli.be_java_hisp_w24_g04.exception.BadRequestException;
import org.socialmeli.be_java_hisp_w24_g04.exception.NotFoundException;
import org.socialmeli.be_java_hisp_w24_g04.model.Discount;
import org.socialmeli.be_java_hisp_w24_g04.model.Post;
import org.socialmeli.be_java_hisp_w24_g04.repository.IDiscountRepository;
import org.socialmeli.be_java_hisp_w24_g04.repository.IPostRepository;
import org.socialmeli.be_java_hisp_w24_g04.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DiscountService implements IDiscountService{
    private final IDiscountRepository discountRepository;
    private final IUserRepository userRepository;
    private final IPostRepository postRepository;
    private final IPostService postService;

    @Autowired
    public DiscountService(
            IDiscountRepository discountRepository,
            IUserRepository userRepository,
            IPostRepository postRepository,
            IPostService postService
    ) {
        this.discountRepository = discountRepository;
        this.userRepository = userRepository;
        this.postRepository = postRepository;
        this.postService = postService;
    }

    public CreatePromoDTO saveDiscount(CreatePromoDTO createEntity) {
        var postId = postRepository.get(createEntity.user_id());

        if (postId.isEmpty())
            postService.createUserPost(new UserPostDTO(
                    createEntity.user_id(),
                    createEntity.date(),
                    createEntity.product(),
                    createEntity.category(),
                    createEntity.price()
            ));

        if (createEntity.has_promo()) {
            var discounts = discountRepository.findAll();
            var discountId = 0;

            if (discounts != null)
                discountId = discounts.size() + 1;

            discountRepository.save(new Discount(
                    discountId,
                    createEntity.product().getProductId(),
                    createEntity.discount()
            ));
        }

        return createEntity;
    }

    public UserDiscountsDTO getDiscountsByUserId(Integer userId) {
        var user = userRepository.get(userId);
        var posts = postRepository
                .findAll()
                .stream()
                .filter(post -> post.getUserId().equals(userId))
                .map(post -> post.getProduct().getProductId())
                .toList();

        var discounts = discountRepository
                .findAll()
                .stream()
                .filter(discount -> posts.contains(discount.getProductId()))
                .toList();

        if (user.isEmpty())
            throw new BadRequestException(String.format("User with ID: %s not found", userId));
        if (posts.isEmpty())
            throw new NotFoundException("There are no posts related with this user.");

        return new UserDiscountsDTO(userId, user.get().getUsername(), discounts.size());
    }
}
