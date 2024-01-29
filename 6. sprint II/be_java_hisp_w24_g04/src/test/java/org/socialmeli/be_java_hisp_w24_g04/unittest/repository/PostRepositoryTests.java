package org.socialmeli.be_java_hisp_w24_g04.unittest.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.socialmeli.be_java_hisp_w24_g04.model.Post;
import org.socialmeli.be_java_hisp_w24_g04.repository.IPostRepository;
import org.socialmeli.be_java_hisp_w24_g04.repository.PostRepository;
import java.util.List;
import java.util.Optional;

public class PostRepositoryTests {

    private final IPostRepository postRepository = new PostRepository();

    @Test
    public void testSavePost() {
        Post post = new Post();
        post.setPostId(1);

        Post savedPost = postRepository.save(post);

        Assertions.assertEquals(post.getPostId(), savedPost.getPostId());
        Assertions.assertTrue(postRepository.findAll().contains(post));
    }

    @Test
    public void testSaveNullPost() {
        Post post = postRepository.save(null);
        Assertions.assertNull(post);
    }

    @Test
    public void testRemovePost() {
        Post post = new Post();
        post.setPostId(1);
        postRepository.save(post);

        Post removedPost = postRepository.remove(1);

        Assertions.assertEquals(post.getPostId(), removedPost.getPostId());
        Assertions.assertFalse(postRepository.findAll().contains(removedPost));
    }

    @Test
    public void testRemoveNonExistentPost() {
        Post removedPost = postRepository.remove(999);
        Assertions.assertNull(removedPost);
    }

    @Test
    public void testGetPost() {
        Post post = new Post();
        post.setPostId(1);
        postRepository.save(post);

        Optional<Post> fetchedPost = postRepository.get(1);

        Assertions.assertTrue(fetchedPost.isPresent());
        Assertions.assertEquals(post.getPostId(), fetchedPost.get().getPostId());
    }

    @Test
    public void testGetNonExistentPost() {
        Optional<Post> fetchedPost = postRepository.get(999);
        Assertions.assertTrue(fetchedPost.isEmpty());
    }

    @Test
    public void testFindAllPosts() {
        Post post = new Post();
        post.setPostId(1);
        postRepository.save(post);

        List<Post> fetchedPosts = postRepository.findAll();

        Assertions.assertFalse(fetchedPosts.isEmpty());
        Assertions.assertTrue(fetchedPosts.contains(post));
    }

    @Test
    public void testUpdatePost() {
        Post post = new Post();
        post.setPostId(1);
        postRepository.save(post);
        post.setCategory(1);

        postRepository.update(post);
        Post updatedPost = postRepository.get(1).get();

        Assertions.assertEquals(post, updatedPost);
    }
}
