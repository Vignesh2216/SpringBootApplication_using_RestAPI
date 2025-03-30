package com.example.demo.controller;

import com.example.demo.entity.Category;
import com.example.demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    // @GetMapping("/category/get")
    // public List<Category> getAllCategories() {
        //     return categoryService.getAllCategories();
        // }
        @GetMapping("/category/get")
        public List<Category> getAllCategories(
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "asc") String sortDir) {
                return categoryService.getAllCategories(sortBy, sortDir);
            }

            // @GetMapping("/category/get/{id}")
            // public ResponseEntity<Category> getCategoryById(@PathVariable Long id) {
                //     return categoryService.getCategoryById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
                // }

                @PostMapping("/category/add")
                public Category createCategory(@RequestBody Category category) {
                    return categoryService.createCategory(category);
                }

                @PutMapping("/category/put/{id}")
                public ResponseEntity<Category> updateCategory(@PathVariable Long id, @RequestBody Category categoryDetails) {
                    return ResponseEntity.ok(categoryService.updateCategory(id, categoryDetails));
                }

                @DeleteMapping("/category/del/{id}")
                public String deleteCategory(@PathVariable Long id) {
                    categoryService.deleteCategory(id);
                    return "Category deleted successfully";
                }
            }