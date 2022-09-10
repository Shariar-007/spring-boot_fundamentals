package com.springpractisewithmyself.blog.services.implementation;

import com.springpractisewithmyself.blog.entities.Category;
import com.springpractisewithmyself.blog.entities.Post;
import com.springpractisewithmyself.blog.entities.User;
import com.springpractisewithmyself.blog.exceptions.ResourceNotFoundException;
import com.springpractisewithmyself.blog.payloads.PostDao;
import com.springpractisewithmyself.blog.payloads.PostResponse;
import com.springpractisewithmyself.blog.repositories.CategoryRepo;
import com.springpractisewithmyself.blog.repositories.PostRepo;
import com.springpractisewithmyself.blog.repositories.UserRepo;
import com.springpractisewithmyself.blog.services.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepo postRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CategoryRepo categoryRepo;

    @Autowired
    private UserRepo userRepo;

    @Override
    public PostDao createPost(PostDao postDao, Integer userId, Integer categoryId) {
        Post post = modelMapper.map(postDao, Post.class);
        if(post.getImage() == null || post.getImage() != "") {
            post.setImage("https://everythingonconstruction.com/oc-content/plugins/blog/img/blog/blog-default.png");
        }
        post.setCreatedDate(new Date());

        User user = userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("user", "id", userId));
        post.setUser(user);

        Category category = categoryRepo.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category", "id", categoryId));
        post.setCategory(category);

        Post savedPost = postRepo.save(post);
        return this.modelMapper.map(savedPost, PostDao.class);
    }

    @Override
    public PostDao updatePost(PostDao postDao, Integer postId) {
        Post foundedPost = postRepo.findById(postId).orElseThrow(() -> new ResourceNotFoundException("post", "id", postId));
        foundedPost.setTitle(postDao.getTitle());
        foundedPost.setContent(postDao.getContent());
        foundedPost.setImage(postDao.getImage());
        Post updatedPost = postRepo.save(foundedPost);
        return this.modelMapper.map(updatedPost, PostDao.class);
    }

    @Override
    public void deletePost(Integer postId) {
        Post post = postRepo.findById(postId).orElseThrow(() -> new ResourceNotFoundException("post", "id", postId));
        postRepo.delete(post);
    }

    @Override
    public PostDao getPostById(Integer postId) {
        Post post = postRepo.findById(postId).orElseThrow(() -> new ResourceNotFoundException("post", "id", postId));
        return modelMapper.map(post, PostDao.class);
    }

    @Override
    public PostResponse getAllPosts(Integer pageNumber, Integer pageSize) {

        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        Page<Post> pagePost = postRepo.findAll(pageable);

        List<Post> posts = pagePost.getContent();
        List<PostDao> postDaos =  posts.stream().map((post) -> modelMapper.map(post, PostDao.class)).collect(Collectors.toList());

        PostResponse postResponse = new PostResponse();
        postResponse.setContent(postDaos);
        postResponse.setPageNumber(pagePost.getNumber());
        postResponse.setPageSize(pagePost.getSize());
        postResponse.setTotalElements(pagePost.getTotalElements());
        postResponse.setTotalPages(pagePost.getTotalPages());
        postResponse.setLastPage(pagePost.isLast());
        return postResponse;
    }

    @Override
    public PostResponse getPostsByUserId(Integer userId, Integer pageNumber, Integer pageSize) {
        User foundedUser = userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("user", "id", userId));

        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        Page<Post> pagePost = postRepo.findAllByUser(foundedUser, pageable);

        List<Post> posts = pagePost.getContent();
        List<PostDao> postDaos =  posts.stream().map((post) -> modelMapper.map(post, PostDao.class)).collect(Collectors.toList());

        PostResponse postResponse = new PostResponse();
        postResponse.setContent(postDaos);
        postResponse.setPageNumber(pagePost.getNumber());
        postResponse.setPageSize(pagePost.getSize());
        postResponse.setTotalElements(pagePost.getTotalElements());
        postResponse.setTotalPages(pagePost.getTotalPages());
        postResponse.setLastPage(pagePost.isLast());

        return postResponse;
    }

    @Override
    public PostResponse getPostsByCategoryId(Integer categoryId, Integer pageNumber, Integer pageSize) {
        Category foundedCategory = categoryRepo.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("category", "id", categoryId));

        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        Page<Post> pagePost = postRepo.findAllByCategory(foundedCategory, pageable);

        List<Post> posts = pagePost.getContent();
        List<PostDao> postDaos =  posts.stream().map((post) -> modelMapper.map(post, PostDao.class)).collect(Collectors.toList());

        PostResponse postResponse = new PostResponse();
        postResponse.setContent(postDaos);
        postResponse.setPageNumber(pagePost.getNumber());
        postResponse.setPageSize(pagePost.getSize());
        postResponse.setTotalElements(pagePost.getTotalElements());
        postResponse.setTotalPages(pagePost.getTotalPages());
        postResponse.setLastPage(pagePost.isLast());

        return postResponse;
    }
}
