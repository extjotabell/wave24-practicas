package com.mercadolibre.blogexercise.service;

import com.mercadolibre.blogexercise.dto.BlogDTO;
import com.mercadolibre.blogexercise.dto.CreateBlogDTO;
import com.mercadolibre.blogexercise.dto.CreateResponseDTO;
import com.mercadolibre.blogexercise.entity.BlogEntity;
import com.mercadolibre.blogexercise.exception.BadRequestException;
import com.mercadolibre.blogexercise.exception.NotFoundException;
import com.mercadolibre.blogexercise.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class BlogService {

    @Autowired
    private BlogRepository blogRepository;

    public CreateResponseDTO createBlog(CreateBlogDTO blogDTO){
        Integer id = blogRepository.findAll().size();
        if(blogRepository.findById(id).isPresent()){
            throw new BadRequestException("El id propocionado ya existe");
        }

        blogRepository.create(new BlogEntity(id, blogDTO.title(), blogDTO.authorName(), blogDTO.publicationName()));
        return new CreateResponseDTO(id);
    }

    public BlogDTO findBlogByID(Integer id){
        BlogEntity blogEntityFinded = this.blogRepository
                .findById(id)
                .orElseThrow(() -> new NotFoundException("Blog de id "+ id + " No existe"));

        return this.transformEntityToDTO(blogEntityFinded);
    }

    public List<BlogDTO> findAllBlogs(){
        return this.blogRepository.findAll().stream().map(this::transformEntityToDTO).collect(Collectors.toList());
    }

    private BlogDTO transformEntityToDTO(BlogEntity blogEntity){
        return new BlogDTO(
                blogEntity.getId(),
                blogEntity.getTitle(),
                blogEntity.getAuthorName(),
                blogEntity.getPublicationDate()
        );
    }
}
