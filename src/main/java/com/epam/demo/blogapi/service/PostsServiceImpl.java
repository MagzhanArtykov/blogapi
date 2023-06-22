package com.epam.demo.blogapi.service;

import com.epam.demo.blogapi.data.entity.Post;
import com.epam.demo.blogapi.data.entity.Tag;
import com.epam.demo.blogapi.data.repository.PostsRepository;
import com.epam.demo.blogapi.data.repository.TagsRepository;
import com.epam.demo.blogapi.util.exceptions.BlogApiException;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PostsServiceImpl implements PostsService {

    private PostsRepository postsRepository;

    public PostsServiceImpl(PostsRepository postsRepository) {
        this.postsRepository = postsRepository;
    }

    @Override
    public List<Post> getPosts() {
        return postsRepository.findAll();
    }

    @Override
    public void createPost(Post post) throws BlogApiException {
        if(post.getTitle() == null || post.getTitle().isEmpty()){
            throw new BlogApiException("Post's title is empty!");
        }
        if(post.getContent() == null || post.getContent().isEmpty()){
            throw new BlogApiException("Post's content is empty!");
        }
        postsRepository.save(post);
    }

    @Override
    public void deletePostById(Long id) throws BlogApiException {
        if(id == null){
            throw new BlogApiException("Id is empty!");
        }
        postsRepository.deleteById(id);
    }

    @Override
    public void updatePostTag(Long id, List<Tag> tags) throws BlogApiException {

        if(id == null){
            throw new BlogApiException("Id is empty!");
        }

        Optional<Post> postOptional = postsRepository.findById(id);
        if(postOptional.isPresent()){
            Post post = postOptional.get();
            post.setTags(tags);
            postsRepository.save(post);
        } else {
            throw new BlogApiException("Post is not found!");
        }
    }
}
