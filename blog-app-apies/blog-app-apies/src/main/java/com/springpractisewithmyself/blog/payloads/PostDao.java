package com.springpractisewithmyself.blog.payloads;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;

@NoArgsConstructor
@Getter
@Setter
public class PostDao {

    private int postId;

    @NotEmpty
    private String title;

    @NotEmpty
    @Size(min = 20, message = "content must be min of 20 characters !!")
    private String content;
    private String image;
    private Date createdDate;
    private UserDto user;
    private CategoryDao category;
}
