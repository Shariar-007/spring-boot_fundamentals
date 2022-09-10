package com.springpractisewithmyself.blog.services;

import com.springpractisewithmyself.blog.payloads.PostDao;
import com.springpractisewithmyself.blog.payloads.PostResponse;

import java.util.List;

public interface PostService {

    public PostDao createPost(PostDao postDao, Integer userId, Integer categoryId);

    public PostDao updatePost(PostDao postDao, Integer postId);

    public void deletePost(Integer postId);

    public PostDao getPostById(Integer postId);

    public PostResponse getAllPosts(Integer pageNumber, Integer pageSize);

    public PostResponse getPostsByUserId(Integer userId, Integer pageNumber, Integer pageSize);

    public PostResponse getPostsByCategoryId(Integer categoryId, Integer pageNumber, Integer pageSize);
}
