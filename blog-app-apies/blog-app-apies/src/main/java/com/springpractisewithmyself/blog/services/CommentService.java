package com.springpractisewithmyself.blog.services;

import com.springpractisewithmyself.blog.payloads.CommentDao;

public interface CommentService {
    CommentDao createComment(CommentDao commentDao, Integer postId);

    void deletedComment(Integer commentId);
}
