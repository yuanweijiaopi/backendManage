package com.seecen.springboot_backendmanagement.controller;

import com.seecen.springboot_backendmanagement.entity.Article;
import com.seecen.springboot_backendmanagement.entity.PageQuery;
import com.seecen.springboot_backendmanagement.entity.Result;
import com.seecen.springboot_backendmanagement.service.ArticleService;
import org.apache.ibatis.annotations.Param;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @ClassName ArticleController
 * @Description TODO
 * @Author aql
 * @Date 2024/12/9 下午12:02
 * @Version 1.0
 **/
@RestController
@RequestMapping("/article")
@Validated
public class ArticleController {
    @Resource
    private ArticleService articleService;


    @PostMapping()
    public Result addCategory(@Validated @RequestBody Article article){
        articleService.addCategory(article);
        return Result.success();
    }

    @GetMapping
    public Result<PageQuery<Article>> list(
            Integer pageNum, Integer pageSize,
            @RequestParam(required = false)  Integer categoryId, @RequestParam(required = false) String state){
        PageQuery<Article> pageQuery=articleService.list(pageNum,pageSize,categoryId,state);
        return Result.success(pageQuery);
    }


}
