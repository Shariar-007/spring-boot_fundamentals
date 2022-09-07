package com.springpractisewithmyself.blog.services;

import com.springpractisewithmyself.blog.payloads.CategoryDao;
import com.springpractisewithmyself.blog.payloads.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CategoryService {

    CategoryDao createCategory(CategoryDao category);

    CategoryDao updateCategory(CategoryDao category, Integer categoryId);

    void deleteCategory(Integer categoryId);

    CategoryDao getCategoryById(Integer categoryId);

    List<CategoryDao> getCategories();

}
