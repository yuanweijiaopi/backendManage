package com.seecen.springboot_backendmangement.controller;

import com.seecen.springboot_backendmangement.entity.Category;
import com.seecen.springboot_backendmangement.entity.Result;
import com.seecen.springboot_backendmangement.service.CategoryService;
import com.seecen.springboot_backendmangement.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

/**
 * @ClassName CategoryController
 * @Description TODO
 * @Author aql
 * @Date 2024/12/12 上午11:27
 * @Version 1.0
 **/
@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    //新增文章分类
    @PostMapping
    public Result addCategory(@Validated(Category.Add.class) @RequestBody Category category) {

        Map<String, Object> map = ThreadLocalUtil.get();
        Integer id = (Integer) map.get("id");
        category.setCreateUser(id);
        categoryService.addCategory(category);

        return Result.success(category);
    }

    //获取当前已登录用户创建的所有文章分类
    @GetMapping
    public Result <List<Category>> getAllCategory() {
      List<Category> categoryList =  categoryService.getAllCategory();
        return Result.success(categoryList);
    }

    //获取文章分类详情
    @GetMapping("/detail")
    public Result <Category> getCategoryDetail(Integer id) {
        Category category = categoryService.getCategoryDetail(id);
        return Result.success(category);
    }


    //更新文章分类
    @PutMapping
    public Result updateCategory(@Validated(Category.Update.class) @RequestBody Category category) {
        categoryService.updateCategory(category);
        return Result.success();
    }


    // 删除文章分类
    @DeleteMapping
    public Result deleteCategory(Integer id) {
        categoryService.deleteCategory(id);
        return Result.success();
    }

//    @PostMapping
//    public Result uploadedFile(@RequestParam("file") MultipartFile file) {
//        return Result.success();
//    }
}
