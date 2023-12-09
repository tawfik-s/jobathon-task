package com.tawfeek.bookstore_admin.service;

import com.tawfeek.bookstore_admin.entity.Category;

import java.util.List;

public interface AdminCategoryService {

    Category addCategory(Category category);

    void deleteCategory(Long id);

    Category updateCategory(Long id,Category newCategory);

    List<Category> getAllCategories();
}
