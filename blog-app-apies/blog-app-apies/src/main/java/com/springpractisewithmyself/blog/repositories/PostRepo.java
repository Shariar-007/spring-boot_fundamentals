package com.springpractisewithmyself.blog.repositories;

import com.springpractisewithmyself.blog.entities.Category;
import com.springpractisewithmyself.blog.entities.Post;
import com.springpractisewithmyself.blog.entities.User;
import com.springpractisewithmyself.blog.payloads.PostDao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepo extends JpaRepository<Post, Integer> {

    public Page<Post> findAllByCategory(Category category, Pageable pageable);

    public Page<Post> findAllByUser(User user, Pageable pageable);

//    public Page<Post> findAllByTitleContainingIgnoreCase(String title);
}
