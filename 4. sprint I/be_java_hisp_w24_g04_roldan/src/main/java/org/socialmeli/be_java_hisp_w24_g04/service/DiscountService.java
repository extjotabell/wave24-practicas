package org.socialmeli.be_java_hisp_w24_g04.service;

import org.socialmeli.be_java_hisp_w24_g04.dto.PromoResponseDTO;
import org.socialmeli.be_java_hisp_w24_g04.dto.PromoWithDiscountPriceDTO;
import org.socialmeli.be_java_hisp_w24_g04.dto.UserDiscountsDTO;
import org.socialmeli.be_java_hisp_w24_g04.dto.UserPostDTO;
import org.socialmeli.be_java_hisp_w24_g04.exception.BadRequestException;
import org.socialmeli.be_java_hisp_w24_g04.exception.NotFoundException;
import org.socialmeli.be_java_hisp_w24_g04.model.Discount;
import org.socialmeli.be_java_hisp_w24_g04.repository.IDiscountRepository;
import org.socialmeli.be_java_hisp_w24_g04.repository.IPostRepository;
import org.socialmeli.be_java_hisp_w24_g04.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public PromoResponseDTO saveDiscount(PromoResponseDTO createEntity) {
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

    @Override
    public List<PromoResponseDTO> getDiscountsBetweenPrices(Double highPrice, Double lowPrice, Boolean onlyPromos) {
        if (highPrice < lowPrice)
            throw new BadRequestException("High price must be higher than low price.");
        if (highPrice.equals(lowPrice))
            throw new BadRequestException("High price and low price must be different.");

        var posts = postRepository
                .findAll()
                .stream()
                .filter(post -> post.getPrice() >= lowPrice && post.getPrice() <= highPrice)
                .toList();

        if (posts.isEmpty())
            throw new NotFoundException("There are no posts between selected prices.");


        var productsIds = posts.stream().map(post -> post.getProduct().getProductId()).toList();
        var discounts = discountRepository
              .findAll()
              .stream()
              .filter(discount -> productsIds.contains(discount.getProductId()))
              .toList();
        var postsToReturn = posts
                .stream()
                .map(post -> {

                    var discountAttached = discounts
                            .stream()
                            .filter(discount -> discount.getProductId().equals(post.getProduct().getProductId()))
                            .findFirst()
                            .orElse(null);

                    return new PromoResponseDTO(
                            post.getUserId(),
                            post.getDate().toString(),
                            post.getProduct(),
                            post.getCategory(),
                            post.getPrice(),
                            discountAttached != null,
                            discountAttached != null ? discountAttached.getDiscount() : 0
                    );
                })
                .toList();

        if (onlyPromos)
            postsToReturn = postsToReturn.stream().filter(PromoResponseDTO::has_promo).toList();

        return postsToReturn;
    }

    @Override
    public List<PromoWithDiscountPriceDTO> getDiscountsWithDiscountPrice() {
        var discounts = discountRepository.findAll();

        if (discounts.isEmpty())
            throw new NotFoundException("There are no discounts.");

        var discountsIds = discounts.stream().map(Discount::getProductId).toList();

        return postRepository
                .findAll()
                .stream()
                .filter(post -> discountsIds.contains(post.getProduct().getProductId()))
                .map(post -> {
                    var discount = discounts
                            .stream()
                            .filter(dis -> dis.getProductId().equals(post.getProduct().getProductId()))
                            .findFirst()
                            .orElse(null);

                    assert discount != null;

                    var price = post.getPrice();
                    var discountPercent = discount.getDiscount();
                    var discountPrice = price * (1 - discountPercent);

                    return new PromoWithDiscountPriceDTO(
                            post.getUserId(),
                            post.getDate().toString(),
                            post.getProduct(),
                            post.getCategory(),
                            price,
                            discountPercent,
                            discountPrice
                    );
                })
                .toList();
    }
}
