package com.seecen.springboot_backendmangement.entity;


import com.seecen.springboot_backendmangement.anno.State;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

/**
 * @author aql
 */
@Data
public class Article {
    //主键ID
    private Integer id;
    //文章标题
    @NotEmpty(message = "id不能为空")
    @Size(min = 1, max = 10, message = "文章标题长度必须在1-100之间")
    private String title;
    //文章内容
    @NotEmpty(message = "id不能为空")
    private String content;
    //封面图像
    @URL(message = "图片格式不正确")
    private String coverImg;
    //发布状态 已发布|草稿
    @NotEmpty(message = "发布状态不能为空")
    @State
    private String state;
    //文章分类id
    @NotEmpty(message = "文章分类ID不能为空")
    private Integer categoryId;
    //创建人ID
    private Integer createUser;
    //创建时间
    private LocalDateTime createTime;
    //更新时间
    private LocalDateTime updateTime;
}
