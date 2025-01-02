package com.seecen.springboot_backendmanagement.service;


import com.seecen.springboot_backendmanagement.entity.Category;

import java.util.List;

/**
 * @author aql
 */
public interface CategoryService {
    void addCategory(Category category);

    List<Category> getAllCategory();

    Category getCategoryDetail(Integer id);

    void updateCategory(Category category);

    void deleteCategory(Integer id);
}
