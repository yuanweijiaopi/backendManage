package com.seecen.springboot_backendmangement.service.impl;

import com.seecen.springboot_backendmangement.entity.Article;
import com.seecen.springboot_backendmangement.mapper.ArticleMapper;
import com.seecen.springboot_backendmangement.service.ArticleService;
import com.seecen.springboot_backendmangement.utils.ThreadLocalUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
}
