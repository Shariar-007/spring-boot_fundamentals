package com.springpractisewithmyself.blog.payloads;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@NoArgsConstructor
@Getter
@Setter
public class CategoryDao {

    private Integer categoryId;

    @NotEmpty
    @Size(min = 4, message = "Category title must have minimum size 4 !!")
    private String categoryTitle;

    @NotEmpty
    @Size(min = 10, message = "Category description must have minimum size 10 !!")
    private String categoryDetails;
}
