package com.epam.demo.blogapi.service;

import com.epam.demo.blogapi.data.entity.Post;
import com.epam.demo.blogapi.data.entity.Tag;
import com.epam.demo.blogapi.util.exceptions.BlogApiException;
import java.util.List;

public interface PostsService {
    List<Post> getPosts();
    void createPost(Post post) throws BlogApiException;
    void deletePostById(Long id) throws BlogApiException;
    void updatePostTag(Long id, List<Tag> tags) throws BlogApiException;
}
