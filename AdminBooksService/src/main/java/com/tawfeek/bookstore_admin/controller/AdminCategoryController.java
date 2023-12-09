package com.tawfeek.bookstore_admin.controller;

import com.tawfeek.bookstore_admin.entity.Category;
import com.tawfeek.bookstore_admin.service.AdminCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class AdminCategoryController {


    @Autowired
    private AdminCategoryService categoryService;



    @GetMapping
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @PostMapping
    public Category addCategory(@RequestBody Category category) {
        return categoryService.addCategory(category);
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
    }

    @PutMapping("/{id}")
    public Category updateCategory(@PathVariable Long id, @RequestBody Category newCategory) {
        return categoryService.updateCategory(id, newCategory);
    }


}
