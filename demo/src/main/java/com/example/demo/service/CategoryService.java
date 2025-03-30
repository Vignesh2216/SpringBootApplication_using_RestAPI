package com.example.demo.service;

import com.example.demo.entity.Category;
import com.example.demo.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import com.example.demo.entity.Product;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAllCategories(String sortBy, String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name())
        ? Sort.by(sortBy).ascending(): Sort.by(sortBy).descending();

        return categoryRepository.findAll(sort);
    }
    public Optional<Category> getCategoryById(Long id) {
        return categoryRepository.findById(id);
    }


    public Category createCategory(Category category) {
        if (category.getProducts() != null) {
            for (Product product : category.getProducts()) {
                product.setCategory(category); // Ensure the relationship is set
            }
        }
        return categoryRepository.save(category);
    }
    public Category updateCategory(Long id, Category categoryDetails) {
        Category category = categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Category not found"));
        category.setName(categoryDetails.getName());
        return categoryRepository.save(category);
    }

    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }
}