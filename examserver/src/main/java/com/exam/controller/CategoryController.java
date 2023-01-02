package com.exam.controller;

import com.exam.models.User;
import com.exam.models.exam.Category;
import com.exam.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
@CrossOrigin("*")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping
    public ResponseEntity<?> addCategory(@RequestBody Category category) {
        Category category1 = this.categoryService.addCategory(category);
        return ResponseEntity.ok(category1);
    }

    @GetMapping
    public ResponseEntity<?> getCategories() {
        return ResponseEntity.ok(this.categoryService.getCategories());
    }

    @GetMapping("/{categoryId}")
    public Category getCategoryById(@PathVariable("categoryId") Long id) {
        return this.categoryService.getCategory(id);
    }

    @PutMapping
    public Category updateCategory(@RequestBody Category category) {
        return this.categoryService.updateCategory(category);
    }

//    @DeleteMapping("/{categoryId}")
//    public void deleteCategory(@PathVariable("categoryId") Long id) {
//        this.categoryService.deleteCategory(id);
//    }
}
