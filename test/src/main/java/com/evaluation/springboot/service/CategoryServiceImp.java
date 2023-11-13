package com.evaluation.springboot.service;

import com.evaluation.springboot.model.BlogPost;
import com.evaluation.springboot.model.Category;
import com.evaluation.springboot.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class CategoryServiceImp implements  CategoryService{
    private CategoryRepository categoryRepository;
    @Override
    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category getCategoryById(Long categoryId) {
        return categoryRepository.findById(categoryId).get();
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category updateCategory(Category category) {
        Category existingCategory = categoryRepository.findById(category.getId()).get();
        existingCategory.setId(category.getId());
        existingCategory.setName(category.getName());


        Category updatedCategory = categoryRepository.save(existingCategory);
        return updatedCategory;
    }

    @Override
    public void deleteCategory(Long catId) {
    categoryRepository.deleteById(catId);
    }

    @Override
    public void deleteAllCategories() {
        categoryRepository.deleteAll();

    }



}
