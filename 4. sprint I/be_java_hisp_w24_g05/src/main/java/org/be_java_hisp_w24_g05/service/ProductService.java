package org.be_java_hisp_w24_g05.service;

import org.be_java_hisp_w24_g05.dto.PostDto;
import org.be_java_hisp_w24_g05.dto.PostPromoDto;
import org.be_java_hisp_w24_g05.dto.ProductDto;
import org.be_java_hisp_w24_g05.entity.Post;
import org.be_java_hisp_w24_g05.entity.Product;
import org.be_java_hisp_w24_g05.exception.NotFoundException;
import org.be_java_hisp_w24_g05.repository.IPostRepository;
import org.be_java_hisp_w24_g05.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements IProductService {

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private IPostRepository postRepository;

    @Override
    public PostDto makePost(PostDto p) {
        Product product = productDtoToProduct(p.product());
        LocalDate date = LocalDate.parse(p.date(), DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        Post post = new Post(postRepository.findLastId() + 1, p.userId(), date, product, p.category(), p.price(), false, 0D);
        postRepository.save(post);
        userRepository.addPost(post);
        return p;
    }

    @Override
    public PostPromoDto makePostPromo(PostPromoDto p) {
        Product product = productDtoToProduct(p.product());
        LocalDate date = LocalDate.parse(p.date(), DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        Post post = new Post(postRepository.findLastId() + 1, p.userId(), date, product, p.category(), p.price(), p.hasPromo(), p.discount());
        postRepository.save(post);
        userRepository.addPost(post);
        return p;
    }

    @Override
    public List<PostPromoDto> getPostPromoDiscount(Integer discount) {
        List<Post> posts = postRepository.findAll().stream().filter(post -> post.getDiscount() == (double) discount /100).toList();
        if (posts.isEmpty()) {
            throw  new NotFoundException("Post with discount " + discount + " not found");
        }
        return posts.stream().map(this::postToPostPromoDto).toList();
    }

    private Product productDtoToProduct(ProductDto pDto){
        return new Product(
                pDto.productId(),
                pDto.productName(),
                pDto.type(),
                pDto.brand(),
                pDto.color(),
                pDto.note());
    }

    private PostPromoDto postToPostPromoDto(Post post){
        return new PostPromoDto(
                post.getUserId(),
                post.getDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")),
                productToProductDto(post.getProduct()),
                post.getCategory(),
                post.getPrice(),
                post.getHasPromo(),
                post.getDiscount());
    }

    private ProductDto productToProductDto(Product product) {
        return new ProductDto(
                product.getProductId(),
                product.getProductName(),
                product.getType(),
                product.getBrand(),
                product.getColor(),
                product.getNote());
    }


}
