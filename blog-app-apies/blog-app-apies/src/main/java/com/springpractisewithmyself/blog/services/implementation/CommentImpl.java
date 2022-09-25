package com.springpractisewithmyself.blog.services.implementation;

import com.springpractisewithmyself.blog.entities.Comment;
import com.springpractisewithmyself.blog.entities.Post;
import com.springpractisewithmyself.blog.exceptions.ResourceNotFoundException;
import com.springpractisewithmyself.blog.payloads.CommentDao;
import com.springpractisewithmyself.blog.repositories.CommentRepo;
import com.springpractisewithmyself.blog.repositories.PostRepo;
import com.springpractisewithmyself.blog.services.CommentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CommentImpl implements CommentService {

    @Autowired
    private CommentRepo commentRepo;

    @Autowired
    private PostRepo postRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CommentDao createComment(CommentDao commentDao, Integer postId) {
        Post post = postRepo.findById(postId).orElseThrow(() -> new ResourceNotFoundException("post", "post id", postId));
        Comment comment = modelMapper.map(commentDao, Comment.class);
        comment.setPost(post);
        Comment savedComment = this.commentRepo.save(comment);
        return modelMapper.map(savedComment, CommentDao.class);
    }

    @Override
    public void deletedComment(Integer commentId) {
        Comment comment  = this.commentRepo.findById(commentId).orElseThrow(() -> new ResourceNotFoundException("comment", "comment id", commentId));
        this.commentRepo.delete(comment);
    }
}
