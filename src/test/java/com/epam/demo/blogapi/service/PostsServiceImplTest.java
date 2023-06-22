package com.epam.demo.blogapi.service;

import com.epam.demo.blogapi.data.entity.Post;
import com.epam.demo.blogapi.util.exceptions.BlogApiException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class PostsServiceImplTest {
    private PostsServiceImpl postsService;

    @BeforeEach
    void init(){
        postsService = new PostsServiceImpl(null);
    }

    @Test
    void createPost_shouldThrowExceptionOnEmptyTitle(){
        Post post = new Post();
        post.setTitle("");
        post.setContent("Dummy content");
        Assertions.assertThrows(BlogApiException.class, ()->postsService.createPost(post));
    }

    @Test
    void createPost_shouldThrowExceptionOnEmptyContent(){
        Post post = new Post();
        post.setTitle("Dummy title");
        post.setContent("");
        Assertions.assertThrows(BlogApiException.class, ()->postsService.createPost(post));
    }

    @Test
    void deletePostById_shouldThrowExceptionOnNullId(){
        Assertions.assertThrows(BlogApiException.class, ()->postsService.deletePostById(null));
    }

    @Test
    void updatePostTag_shouldThrowExceptionOnNullId(){
        Assertions.assertThrows(BlogApiException.class, ()->postsService.updatePostTag(null, new ArrayList<>()));
    }

}