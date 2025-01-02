package com.seecen.springboot_backendmanagement.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.seecen.springboot_backendmanagement.entity.Article;
import com.seecen.springboot_backendmanagement.entity.PageQuery;
import com.seecen.springboot_backendmanagement.mapper.ArticleMapper;
import com.seecen.springboot_backendmanagement.service.ArticleService;
import com.seecen.springboot_backendmanagement.utils.ThreadLocalUtil;
import org.hibernate.validator.internal.constraintvalidators.bv.notempty.NotEmptyValidatorForArraysOfInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @ClassName ArticleServiceImpl
 * @Description TODO
 * @Author aql
 * @Date 2024/12/26 11:06
 * @Version 1.0
 **/
@Service
public class ArticleServiceImpl implements ArticleService {

    @Resource
    private ArticleMapper articleMapper;


    @Override
    public void addCategory(Article article) {
        Map<String,Object> map = ThreadLocalUtil.get();
        Integer userId = (Integer) map.get("id");
        article.setCreateUser(userId);
        articleMapper.addArticle(article);
    }

    @Override
    public PageQuery<Article> list(Integer pageNum, Integer pageSize, Integer categoryId, String state) {
        //创建pageQuery对象
        PageQuery<Article> pageQuery = new PageQuery<>();
        //开启分页查询
        PageHelper.startPage(pageNum,pageSize);

        //调用mapper
        Map<String,Object> map = ThreadLocalUtil.get();
        Integer userId = (Integer) map.get("id");
        List<Article> as = articleMapper.list(userId,categoryId,state);
        //Page中提供了方法，可以获取pagehelper分页查询，得到的总记录条数和当前页数据
        Page<Article> p = (Page<Article>) as;

        //把数据填充到pageQuery当中
        pageQuery.setTotal(p.getTotal());
        pageQuery.setItems(p.getResult());
        return pageQuery;
    }
}
