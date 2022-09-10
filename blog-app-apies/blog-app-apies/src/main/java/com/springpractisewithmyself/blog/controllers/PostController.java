package com.springpractisewithmyself.blog.controllers;

import com.springpractisewithmyself.blog.payloads.ApiResponse;
import com.springpractisewithmyself.blog.payloads.PostDao;
import com.springpractisewithmyself.blog.payloads.PostResponse;
import com.springpractisewithmyself.blog.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping("/user/{userId}/category/{categoryId}/post")
    public ResponseEntity<PostDao> createPost(@Valid @RequestBody PostDao postDao,
                                              @PathVariable Integer userId,
                                              @PathVariable Integer categoryId) {
        PostDao createdPost = postService.createPost(postDao, userId, categoryId);
        return new ResponseEntity<>(createdPost, HttpStatus.CREATED);
    }

    @PutMapping("/posts/{postId}")
    public ResponseEntity<PostDao> updatePost(@Valid @RequestBody PostDao postDao, @PathVariable Integer postId) {
        PostDao updatedPost = postService.updatePost(postDao, postId);
        return new ResponseEntity<>(updatedPost, HttpStatus.OK);
    }

    @GetMapping("/user/{userId}/posts")
    public ResponseEntity<PostResponse> getPostsByUser(@PathVariable Integer userId,
                                                       @RequestParam(value = "pageNumber", defaultValue = "0", required = false) Integer pageNumber,
                                                       @RequestParam(value = "pageSize", defaultValue = "10", required = false) Integer pageSize,
                                                       @RequestParam(value = "sortBy", defaultValue = "postId", required = false) String sortBy,
                                                       @RequestParam(value = "sortType", defaultValue = "desc", required = false) String sortType) {
        PostResponse postResponse = postService.getPostsByUserId(userId, pageNumber, pageSize, sortBy, sortType);
        return new ResponseEntity<>(postResponse, HttpStatus.OK);
    }

    @GetMapping("/category/{categoryId}/posts")
    public ResponseEntity<PostResponse> getPostsByCategory(@PathVariable Integer categoryId,
                                                           @RequestParam(value = "pageNumber", defaultValue = "0", required = false) Integer pageNumber,
                                                           @RequestParam(value = "pageSize", defaultValue = "10", required = false) Integer pageSize,
                                                           @RequestParam(value = "sortBy", defaultValue = "postId", required = false) String sortBy,
                                                           @RequestParam(value = "sortType", defaultValue = "desc", required = false) String sortType) {
        PostResponse postResponse = postService.getPostsByCategoryId(categoryId, pageNumber, pageSize, sortBy, sortType);
        return new ResponseEntity<>(postResponse, HttpStatus.OK);
    }

    @GetMapping("/posts")
    public ResponseEntity<PostResponse> getPosts(@RequestParam(value = "pageNumber", defaultValue = "0", required = false) Integer pageNumber,
                                                 @RequestParam(value = "pageSize", defaultValue = "10", required = false) Integer pageSize,
                                                 @RequestParam(value = "sortBy", defaultValue = "postId", required = false) String sortBy,
                                                 @RequestParam(value = "sortType", defaultValue = "desc", required = false) String sortType) {
        PostResponse pagepost = postService.getAllPosts(pageNumber, pageSize, sortBy, sortType);
        return new ResponseEntity<PostResponse>(pagepost, HttpStatus.OK);
    }

    @GetMapping("/posts/{postId}")
    public ResponseEntity<PostDao> getPostById(@PathVariable Integer postId) {
        PostDao post = postService.getPostById(postId);
        return new ResponseEntity<>(post, HttpStatus.OK);
    }

    @DeleteMapping("/posts/{postId}")
    public ResponseEntity<ApiResponse> deletePost(@PathVariable Integer postId) {
        postService.deletePost(postId);
        return new ResponseEntity<>(new ApiResponse("Post Deleted Successfully", true), HttpStatus.OK);
    }
}
