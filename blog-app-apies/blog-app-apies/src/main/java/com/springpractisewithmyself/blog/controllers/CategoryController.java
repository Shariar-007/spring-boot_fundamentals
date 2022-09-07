package com.springpractisewithmyself.blog.controllers;

import com.springpractisewithmyself.blog.payloads.ApiResponse;
import com.springpractisewithmyself.blog.payloads.CategoryDao;
import com.springpractisewithmyself.blog.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping
    public ResponseEntity<CategoryDao> createCategory(@Valid @RequestBody CategoryDao categoryDao) {
        CategoryDao createdCategory = categoryService.createCategory(categoryDao);
        return new ResponseEntity<>(createdCategory, HttpStatus.CREATED);
    }

    @PutMapping("/{categoryId}")
    public ResponseEntity<CategoryDao> updateCategory(@Valid @RequestBody CategoryDao categoryDao, @PathVariable("categoryId") Integer categoryId) {
        CategoryDao updatedCategory = categoryService.updateCategory(categoryDao, categoryId);
        return new ResponseEntity<>(updatedCategory, HttpStatus.OK);
    }

    @DeleteMapping("/{categoryId}")
    public ResponseEntity<ApiResponse> removeCategory(@PathVariable("categoryId") Integer categoryId) {
        categoryService.deleteCategory(categoryId);
        return new ResponseEntity<>(new ApiResponse("User Deleted Successfully", true), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<CategoryDao>> getAllCategory() {
        return ResponseEntity.ok(categoryService.getCategories());
    }

    @GetMapping("/{categoryId}")
    public ResponseEntity<CategoryDao> getCategoryById(@PathVariable("categoryId") Integer categoryId) {
        CategoryDao foundedCategory = categoryService.getCategoryById(categoryId);
        return new ResponseEntity<>(foundedCategory, HttpStatus.OK);
    }

}
