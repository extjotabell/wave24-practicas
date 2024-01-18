package com.socialmeli.SocialMeli.service.implementations;

import com.socialmeli.SocialMeli.dto.*;
import com.socialmeli.SocialMeli.entity.Category;
import com.socialmeli.SocialMeli.entity.Post;
import com.socialmeli.SocialMeli.entity.Product;
import com.socialmeli.SocialMeli.entity.PromoPost;
import com.socialmeli.SocialMeli.exception.*;
import com.socialmeli.SocialMeli.repository.interfaces.ICategoryRepository;
import com.socialmeli.SocialMeli.repository.interfaces.IPostRepository;
import com.socialmeli.SocialMeli.repository.interfaces.IProductRepository;
import com.socialmeli.SocialMeli.repository.interfaces.IUserRepository;
import com.socialmeli.SocialMeli.service.interfaces.IPostService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
        if(!this.userRepository.userExists(postDTO.user_id())){
            throw new UserNotFoundException("User id: "+postDTO.user_id()+ " not found.");
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
                        postDTO.price())
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
    public PromoPostResponseDTO createPromoPost(PromoPostRequestDTO postDTO) {
        //Publish a new post with a discount
        //validateFields() {
        if (postDTO.user_id() == null) {
            throw new BadRequestException("User ID can not be null");
        }
        if (postDTO.date() == null) {
            throw new BadRequestException("Date can not be null");
        }
        if (postDTO.category() == null) {
            throw new BadRequestException("Category can not be null");
        }
        if (postDTO.price() == null) {
            throw new BadRequestException("Price can not be null");
        }
        if (postDTO.has_promo() == null) {
            throw new BadRequestException("Has promo can not be null");
        }
        if (postDTO.discount() == null) {
            throw new BadRequestException("Discount can not be null");
        }
        //Find the product or create it if it doesnt exists
        Product product = this.productRepository.findByIdOrCreate(postDTO.product());
        //Find the category and return error if it doesnt exists
        Category category = this.categoryRepository.findByIdNoDTO(postDTO.category());
        //Retrieve last ID to automatically increment by 1
        int lastId = postRepository.findLastId();
        //Verify that the user exists
        if(!userRepository.userExists(postDTO.user_id())){
            throw new UserNotFoundException("The user id: " + postDTO.user_id() + " was not found");
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        PromoPost promoPostToCreate = postRepository.createPromoPost(
                new PromoPost(
                        lastId + 1,
                        postDTO.user_id(),
                        LocalDate.parse(postDTO.date(), formatter),
                        product,
                        category,
                        postDTO.price(),
                        postDTO.has_promo(),
                        postDTO.discount())
        );
        return new PromoPostResponseDTO(
                promoPostToCreate.getId(),
                promoPostToCreate.getUserId(),
                promoPostToCreate.getDate().toString(),
                promoPostToCreate.getProduct().getId(),
                promoPostToCreate.getProduct().getProductName(),
                promoPostToCreate.getCategory().getId(),
                promoPostToCreate.getCategory().getName(),
                promoPostToCreate.getPrice(),
                promoPostToCreate.getHasPromo(),
                promoPostToCreate.getDiscount()
        );

    }

    //Obtener la cantidad de productos en promoción de un determinado vendedor
    @Override
    public PromoPostCountDTO getPromoPostCount(Integer userId) {
        //Validate that the user exists
        if(!userRepository.userExists(userId)){
            throw new UserNotFoundException("The user id: " + userId + " was not found");
        }
        //Get the posts by user
        var posts = postRepository.getAllPostsByIdNoTimeValidation(userId);
        //Print all of the posts
        posts.forEach(post -> System.out.println(post.toString()));
        //Filter the posts when they are of class promopost
        Long postsPromo = posts.stream().filter(post -> post instanceof PromoPost).count();
        //Cast to Integer as required for the DTO
        Integer postsPromoInt = postsPromo.intValue();
        //Get the user name for the DTO
        String userName = userRepository.findById(userId).get().getName();

        return new PromoPostCountDTO(userId, userName, postsPromoInt);
    }
}
