package org.socialmeli.be_java_hisp_w24_g04.unittest.repository;

import org.junit.jupiter.api.Test;
import org.socialmeli.be_java_hisp_w24_g04.repository.IPostRepository;
import org.socialmeli.be_java_hisp_w24_g04.repository.PostRepository;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class PostRepositoryTests {

     IPostRepository postRepository = new PostRepository(new ArrayList<>());

    @Test
    public void removePostTest() {

        Integer postIdToRemove = 1;

        postRepository.remove(postIdToRemove);

        assertEquals(postRepository.get(postIdToRemove), Optional.empty());
    }
}
