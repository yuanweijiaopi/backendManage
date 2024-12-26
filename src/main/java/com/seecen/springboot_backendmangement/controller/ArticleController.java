package com.seecen.springboot_backendmangement.controller;

import com.seecen.springboot_backendmangement.entity.Article;
import com.seecen.springboot_backendmangement.entity.Category;
import com.seecen.springboot_backendmangement.entity.Result;
import com.seecen.springboot_backendmangement.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public Result addCategory(@RequestBody Article article){
        articleService.addCategory(article);
        return Result.success();
    }


}
