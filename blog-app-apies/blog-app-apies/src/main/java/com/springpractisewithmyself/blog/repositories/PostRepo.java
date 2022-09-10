package com.springpractisewithmyself.blog.repositories;

import com.springpractisewithmyself.blog.entities.Category;
import com.springpractisewithmyself.blog.entities.Post;
import com.springpractisewithmyself.blog.entities.User;
import com.springpractisewithmyself.blog.payloads.PostDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepo extends JpaRepository<Post, Integer> {

    public List<Post> findAllByCategory(Category category);

    public List<Post> findAllByUser(User user);
}
