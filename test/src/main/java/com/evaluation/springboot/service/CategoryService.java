package com.evaluation.springboot.service;

import com.evaluation.springboot.model.Category;

import java.util.List;

public interface CategoryService {
    Category createCategory(Category category);

    Category getCategoryById(Long categoryId);

    List<Category> getAllCategories();

    Category updateCategory(Category blogPost);

    void deleteCategory(Long blogId);
    void deleteAllCategories();
    }
