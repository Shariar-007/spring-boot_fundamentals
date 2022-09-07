package com.springpractisewithmyself.blog.services.implementation;

import com.springpractisewithmyself.blog.entities.Category;
import com.springpractisewithmyself.blog.exceptions.ResourceNotFoundException;
import com.springpractisewithmyself.blog.payloads.CategoryDao;
import com.springpractisewithmyself.blog.repositories.CategoryRepo;
import com.springpractisewithmyself.blog.services.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepo categoryRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CategoryDao createCategory(CategoryDao categoryDao) {
        Category category = modelMapper.map(categoryDao, Category.class);
        Category newCategory = categoryRepo.save(category);
        return modelMapper.map(newCategory, CategoryDao.class);
    }

    @Override
    public CategoryDao updateCategory(CategoryDao categoryDao, Integer categoryId) {
        Category foundedCategory = categoryRepo.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category", "id", categoryId));
        foundedCategory.setCategoryTitle(categoryDao.getCategoryTitle());
        foundedCategory.setCategoryDetails(categoryDao.getCategoryDetails());
        Category savedCategory = categoryRepo.save(foundedCategory);
        return modelMapper.map(savedCategory, CategoryDao.class);
    }

    @Override
    public void deleteCategory(Integer categoryId) {
        Category foundedCategory = categoryRepo.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category", "id", categoryId));
        categoryRepo.delete(foundedCategory);
    }

    @Override
    public CategoryDao getCategoryById(Integer categoryId) {
        Category foundedCategory = categoryRepo.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category", "id", categoryId));
        return modelMapper.map(foundedCategory, CategoryDao.class);
    }

    @Override
    public List<CategoryDao> getCategories() {
        List<CategoryDao> categoryDaos = categoryRepo.findAll().stream().map(category ->  modelMapper.map(category, CategoryDao.class)).collect(Collectors.toList());
        return categoryDaos;
    }
}
