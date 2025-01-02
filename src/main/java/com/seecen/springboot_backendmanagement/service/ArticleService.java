package com.seecen.springboot_backendmanagement.service;

import com.seecen.springboot_backendmanagement.entity.Article;
import com.seecen.springboot_backendmanagement.entity.PageQuery;

/**
 * @ClassName ArticleService
 * @Description TODO
 * @Author aql
 * @Date 2024/12/26 11:05
 * @Version 1.0
 **/
public interface ArticleService {

    //新增文章
     void addCategory(Article article);

     //条件分页列表查询
    PageQuery<Article> list(Integer pageNum, Integer pageSize, Integer categoryId, String state);
}
