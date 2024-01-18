package com.socialmeli.SocialMeli.service.implementations;

import com.socialmeli.SocialMeli.dto.*;
import com.socialmeli.SocialMeli.entity.Category;
import com.socialmeli.SocialMeli.entity.Post;
import com.socialmeli.SocialMeli.entity.Product;
import com.socialmeli.SocialMeli.entity.User;
import com.socialmeli.SocialMeli.exception.*;
import com.socialmeli.SocialMeli.repository.interfaces.ICategoryRepository;
import com.socialmeli.SocialMeli.repository.interfaces.IPostRepository;
import com.socialmeli.SocialMeli.repository.interfaces.IProductRepository;
import com.socialmeli.SocialMeli.repository.interfaces.IUserRepository;
import com.socialmeli.SocialMeli.service.interfaces.IPostService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PostService implements IPostService {
    private final IPostRepository postRepository;
    private final IProductRepository productRepository;
    private final IUserRepository userRepository;
    private final ICategoryRepository categoryRepository;
    public PostService(IPostRepository postRepository, IProductRepository productRepository, IUserRepository userRepository, ICategoryRepository categoryRepository) {
        this.postRepository = postRepository;
        this.productRepository = productRepository;
        this.userRepository = userRepository;
        this.categoryRepository = categoryRepository;
    }
    @Override
    public PostResponseDTO createPost(PostRequestDTO postDTO) {
        Product product = this.productRepository.findByIdOrCreate(postDTO.product());
        Category category = this.categoryRepository.findByIdOrCreate(postDTO.category());
        int lastId = postRepository.findLastId();
        Post post = postRepository.create(
                new Post(
                        lastId + 1,
                        postDTO.user_id(),
                        postDTO.date(),
                        product,
                        category,
                        postDTO.price(),
                        false,
                        0D
                )
        );

        return new PostResponseDTO(
                post.getId(),
                post.getUserId(),
                post.getDate().toString(),
                post.getProduct().getId(),
                post.getProduct().getProductName(),
                post.getCategory().getId(),
                post.getCategory().getName(),
                post.getPrice()
        );
    }

    @Override
    public PostPromoResponseDTO createPromoPost(PostPromoRequestDTO postDTO) {
        if (!this.userRepository.userExists(postDTO.user_id())) {
            throw new UserNotFoundException("The user id: " + postDTO.user_id() + " not found");
        }
        Product product = this.productRepository.findByIdOrCreate(postDTO.product());
        Category category = this.categoryRepository.findByIdOrCreate(postDTO.category());
        int lastId = postRepository.findLastId();
        Post post = postRepository.create(
                new Post(
                        lastId + 1,
                        postDTO.user_id(),
                        postDTO.date(),
                        product,
                        category,
                        postDTO.price(),
                        postDTO.has_promo(),
                        postDTO.discount()
                )
        );
        return parsePostToDTO(post);
    }

    public PostPromoResponseDTO parsePostToDTO(Post post) {
        return new PostPromoResponseDTO(
                post.getId(),
                post.getUserId(),
                post.getDate().toString(),
                post.getProduct().getId(),
                post.getProduct().getProductName(),
                post.getCategory().getId(),
                post.getCategory().getName(),
                post.getPrice(),
                post.getHasPromo(),
                post.getDiscount()
        );
    }

    public CategoryPostRequestDTO parseCategoryToDTO(Category category) {
        return new CategoryPostRequestDTO(
                category.getId(),
                category.getName()
        );
    }
    public ProductPostRequestDTO parseProductToDTO(Product product) {
        return new ProductPostRequestDTO(
                product.getId(),
                product.getProductName(),
                product.getType(),
                product.getBrand(),
                product.getColor(),
                product.getNotes()
        );
    }
    @Override
    public LastestPostDTO getLastestPost(Integer userId, String order) {

        //Se trae al usuario y lo mandamos al repositorio
        var user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("The user id: " + userId + " not found"));
        var usersFollowed = user.getFollowed();
        if (usersFollowed.isEmpty()) {//Si no sigue a nadie, lanzamos una excepción
            throw new EmptyListException("You are not following any user");
        }

        //Se llaman a los posts por usuario
        List<PostWithIdDTO> postFiltered = new ArrayList<>();
        usersFollowed.forEach((uf) ->{
            postRepository.getAllPostsById(uf.getId()).stream().forEach(post -> {
                var searchCategory = categoryRepository.findByIdOrCreate(
                        parseCategoryToDTO(post.getCategory())
                );
                var searchProduct = productRepository.findByIdOrCreate(
                        parseProductToDTO(post.getProduct())
                );
                PostWithIdDTO postWithIdDTO = new PostWithIdDTO(
                        post.getUserId(),
                        post.getId(),
                        post.getDate(),
                        parseProductToDTO(searchProduct),
                        parseCategoryToDTO(searchCategory),
                        post.getPrice());
                postFiltered.add(postWithIdDTO);
            });
        });


        LastestPostDTO lastestPostDTO = new LastestPostDTO(user.getId(),postFiltered);

        if (lastestPostDTO.posts().isEmpty()) {//Si no hay contenido, lanzamos una excepción
            throw new EmptyListException("No posts found from the last two weeks");
        }
        switch (order) {
            case "date_asc":
                lastestPostDTO.posts().sort(Comparator.comparing(PostWithIdDTO::date));
                break;
            case "date_desc":
                lastestPostDTO.posts().sort(Comparator.comparing(dto -> ((PostWithIdDTO) dto).date()).reversed());
                break;
        }

        return lastestPostDTO;
    }

    public String checkOrder(String order){
        Set<String> orders = new HashSet<>(Arrays.asList("date_asc","date_desc"));

        if (order == null ){
            order = "date_desc";
        } else if (!orders.contains(order)) {
            throw new OrderNotFoundException(order);
        }

        return order;
    }

    @Override
    public PostPromoCountResponseDTO getPromoCountByUserId(Integer userId) {
        User user = this.userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User id: " +userId + " not found."));
        Integer promoProductsCount = this.postRepository.findAllByUserId(user.getId())
                .stream().filter(p -> p.getHasPromo() != null && p.getHasPromo()).toList()
                .size();
        return new PostPromoCountResponseDTO(
                user.getId(),
                user.getName(),
                promoProductsCount
        );
    }

}
