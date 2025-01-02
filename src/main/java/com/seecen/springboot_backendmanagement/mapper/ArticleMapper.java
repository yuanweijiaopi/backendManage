package com.seecen.springboot_backendmanagement.mapper;

import com.seecen.springboot_backendmanagement.entity.Article;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ArticleMapper {


    @Insert("insert into article(title, content, cover_img, state,category_id,create_user,create_time,update_time)" +
            "values(#{title},#{content},#{coverImg},#{state},#{categoryId},#{createUser},NOW(),NOW())")
    void addArticle(Article article);


    List<Article> list(@Param("userId") Integer userId, @Param("categoryId") Integer categoryId,@Param("state") String state);
}
