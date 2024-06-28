package com.example.shopapp.services;

import com.example.shopapp.dtos.CategoryDTO;
import com.example.shopapp.models.Category;

import java.util.List;

public interface ICategoryService {
    Category createCategory(CategoryDTO category);

    Category getCategoryById(Long id);

    List<Category> getAllCategory();

    Category updateCategory(Long id, CategoryDTO category);

    void deleteCategory(Long id);
}
