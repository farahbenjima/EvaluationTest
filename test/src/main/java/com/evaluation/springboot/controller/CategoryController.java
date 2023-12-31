package com.evaluation.springboot.controller;

import com.evaluation.springboot.model.BlogPost;
import com.evaluation.springboot.model.Category;
import com.evaluation.springboot.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/categories")
public class CategoryController {
    private CategoryService categoryService;
    @GetMapping
    public ResponseEntity<List<Category>> getAll(){
        List<Category> allCategories = categoryService.getAllCategories();
        return new ResponseEntity<>(allCategories, HttpStatus.OK);
    }
}
