package com.seecen.springboot_backendmangement.service;


import com.seecen.springboot_backendmangement.entity.Category;

import java.util.List;

/**
 * @author aql
 */
public interface CategoryService {
    void addCategory(Category category);

    List<Category> getAllCategory();

    Category getCategoryDetail(Integer id);

    void updateCategory(Category category);
}
