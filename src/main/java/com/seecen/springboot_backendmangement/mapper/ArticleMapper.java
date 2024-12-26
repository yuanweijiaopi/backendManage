package com.seecen.springboot_backendmangement.mapper;

import com.seecen.springboot_backendmangement.entity.Article;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ArticleMapper {


    @Insert("insert into article(title, content, cover_img, state,category_id,create_user,create_time,update_time)" +
            "values(#{title},#{content},#{coverImg},#{state},#{categoryId},#{createUser},NOW(),NOW())")
    void addArticle(Article article);
}
