package com.epam.demo.blogapi.rest;

import com.epam.demo.blogapi.data.entity.Post;
import com.epam.demo.blogapi.data.entity.Tag;
import com.epam.demo.blogapi.service.PostsService;
import com.epam.demo.blogapi.util.exceptions.BlogApiException;
import com.epam.demo.blogapi.util.exceptions.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostsRest {

    private final PostsService postsService;

    public PostsRest(PostsService postsService) {
        this.postsService = postsService;
    }

    @GetMapping
    public ResponseEntity<List<Post>> getPosts(){
        return new ResponseEntity<>(postsService.getPosts(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Response> createPost(@RequestBody Post post) throws BlogApiException {
        postsService.createPost(post);
        return new ResponseEntity<>(new Response(true, HttpStatus.CREATED.value(), "Post successfully created!"), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response> deletePostById(@PathVariable(name = "id") Long id) throws BlogApiException {
        postsService.deletePostById(id);
        return new ResponseEntity<>(new Response(true, HttpStatus.OK.value(), "Post successfully deleted!"), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Response> updatePostTag(@PathVariable(name = "id") Long id, @RequestBody List<Tag> tags) throws BlogApiException {
        postsService.updatePostTag(id, tags);
        return new ResponseEntity<>(new Response(true, HttpStatus.OK.value(), "Tags successfully updated!"), HttpStatus.OK);
    }

}
