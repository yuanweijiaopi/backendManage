package com.seecen.springboot_backendmanagement.service.impl;

import com.seecen.springboot_backendmanagement.entity.Category;
import com.seecen.springboot_backendmanagement.mapper.CategoryMapper;
import com.seecen.springboot_backendmanagement.service.CategoryService;
import com.seecen.springboot_backendmanagement.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @ClassName addArticleImpl
 * @Description TODO
 * @Author aql
 * @Date 2024/12/12 上午11:08
 * @Version 1.0
 **/

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public void addCategory(Category category) {
        categoryMapper.addCategory(category);
    }

    @Override
    public List<Category> getAllCategory() {
        Map<String, Object> map = ThreadLocalUtil.get();
        Integer id = (Integer) map.get("id");
        return  categoryMapper.getAllCategory(id);
    }

    @Override
    public Category getCategoryDetail(Integer id) {
        return categoryMapper.getCategoryDetail(id);
    }

    @Override
    public void updateCategory(Category category) {
        categoryMapper.updateCategory(category);
    }

    @Override
    public void deleteCategory(Integer id) {
        categoryMapper.deleteCategory(id);

    }
}
