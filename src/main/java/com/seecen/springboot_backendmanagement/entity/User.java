package com.seecen.springboot_backendmanagement.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.internal.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

//lombok  在编译阶段,为实体类自动生成setter  getter toString
// pom文件中引入依赖   在实体类上添加注解
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    //主键ID
    @NotNull
    private Integer id;
    //用户名
    private String username;
    //密码
    @JsonIgnore//让springmvc把当前对象转换成json字符串的时候,忽略password,最终的json字符串中就没有password这个属性了
    private String password;
    //昵称
    @NotEmpty
    @Pattern(regexp = "^[a-zA-Z0-9\\u4e00-\\u9fa5]+$", message = "昵称只能包含中文、英文、数字")
    @Size(min = 2, max = 10, message = "昵称长度必须在2-10之间")
    private String nickname;
    //邮箱
    @Email
    @NotEmpty
    private String email;
    //用户头像地址
    private String userPic;
    //创建时间
    private LocalDateTime createTime;
    //更新时间
    private LocalDateTime updateTime;
}
