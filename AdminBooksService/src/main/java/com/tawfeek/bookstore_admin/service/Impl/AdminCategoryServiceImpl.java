package com.tawfeek.bookstore_admin.service.Impl;

import com.tawfeek.bookstore_admin.entity.Category;
import com.tawfeek.bookstore_admin.repository.CategoryRepository;
import com.tawfeek.bookstore_admin.service.AdminCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminCategoryServiceImpl implements AdminCategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category addCategory(Category category) {
        category.setId(null);
        if(category.getName()==null){
            throw new IllegalArgumentException("category name should not equal null");
        }

        return categoryRepository.save(category);
    }

    @Override
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public Category updateCategory(Long id,Category newCategory) {
        Category category=categoryRepository.findById(id).orElseThrow();
        if(newCategory.getName()!=null){
            category.setName(newCategory.getName());
        }
        return categoryRepository.save(category);
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }
}
