package com.epam.demo.blogapi.service;

import com.epam.demo.blogapi.data.entity.Post;
import com.epam.demo.blogapi.data.entity.Tag;
import com.epam.demo.blogapi.data.repository.PostsRepository;
import com.epam.demo.blogapi.data.repository.TagsRepository;
import com.epam.demo.blogapi.util.exceptions.BlogApiException;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PostsServiceImpl implements PostsService {

    private PostsRepository postsRepository;

    private TagsRepository tagsRepository;

    public PostsServiceImpl(PostsRepository postsRepository, TagsRepository tagsRepository) {
        this.postsRepository = postsRepository;
        this.tagsRepository = tagsRepository;
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
        post.setTags(resolveTags(post.getTags()));
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
            post.setTags(resolveTags(tags));
            postsRepository.save(post);
        } else {
            throw new BlogApiException("Post is not found!");
        }
    }

    private List<Tag> resolveTags(List<Tag> inTags){
        List<Tag> tags = new ArrayList<>();
        if(!CollectionUtils.isEmpty(inTags)) {
            inTags.forEach((a) -> {
                Optional<Tag> tag = tagsRepository.findByName(a.getName());
                if (tag.isPresent()) {
                    tags.add(tag.get());
                } else {
                    tags.add(a);
                }
            });
        }
        return tags;
    }
}
