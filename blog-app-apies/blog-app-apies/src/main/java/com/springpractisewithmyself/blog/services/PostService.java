package com.springpractisewithmyself.blog.services;

import com.springpractisewithmyself.blog.payloads.PostDao;

import java.util.List;

public interface PostService {

    public PostDao createPost(PostDao postDao, Integer userId, Integer categoryId);

    public PostDao updatePost(PostDao postDao, Integer postId);

    public void deletePost(Integer postId);

    public PostDao getPostById(Integer postId);

    public List<PostDao> getAllPosts(Integer pageNumber, Integer pageSize);

    public List<PostDao> getPostsByUserId(Integer userId);

    public List<PostDao> getPostsByCategoryId(Integer categoryId);
}
