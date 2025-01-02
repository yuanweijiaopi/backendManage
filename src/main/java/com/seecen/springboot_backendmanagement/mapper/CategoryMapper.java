package com.seecen.springboot_backendmanagement.mapper;

import com.seecen.springboot_backendmanagement.entity.Category;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @ClassName ArticleMapper
 * @Description TODO
 * @Author aql
 * @Date 2024/12/12 上午11:15
 * @Version 1.0
 **/
@Mapper
public interface CategoryMapper {


    @Insert("insert into Category(category_name,category_alias,create_user,create_time,update_time) " +
            "values(#{categoryName},#{categoryAlias}, #{createUser}, NOW(),NOW())")
    void addCategory(Category category);


    @Select("select * from Category where create_user = #{createUser}")
    List<Category> getAllCategory(Integer id);

    //根据id查询
    @Select("select * from Category where id = #{id}")
    Category getCategoryDetail(Integer id);


    @Update("update Category set category_name = #{categoryName}, category_alias = #{categoryAlias}, update_time = NOW() where id = #{id}")
    void updateCategory(Category category);

    @Delete("delete from category where id = #{id}")
    void deleteCategory(Integer id);
}
