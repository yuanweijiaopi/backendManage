package com.seecen.springboot_backendmangement.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;
@Data
public class Category {
    //主键ID
    private Integer id;
    //分类名称
    private String categoryName;
    //分类别名
    private String categoryAlias;
    //创建人ID
    private Integer createUser;
    //创建时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;
    //更新时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;

    //如果说某个校验项没有指定分组,默认属于Default分组
    //分组之间可以继承, A extends B  那么A中拥有B中所有的校验项


//    public interface Add extends Default {
//
//    }
//
//    public interface Update extends Default{
//
//    }
}
