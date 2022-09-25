package com.springpractisewithmyself.blog.repositories;
import com.springpractisewithmyself.blog.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CommentRepo extends JpaRepository<Comment, Integer> {

}
