package com.seecen.springboot_backendmanagement.mapper;

import com.seecen.springboot_backendmanagement.entity.User;
import org.apache.ibatis.annotations.*;

/**
 * @ClassName UserMapper
 * @Description TODO
 * @Author aql
 * @Date 2024/12/6 下午5:18
 * @Version 1.0
 **/
@Mapper
public interface UserMapper {
    //根据用户名查找用户
    @Select("SELECT * FROM user WHERE username = #{username}")
    User findUserByUsername(String username);

//    添加
    @Insert("INSERT INTO user(username, password,create_time,update_time)" +
            " VALUES(#{username}, #{password}, NOW(), NOW())")
    void add(@Param("username") String username, @Param("password") String password);


    //更新用户信息
    @Update("UPDATE user SET " +
            "username = #{username}, " +
            "nickname = #{nickname}," +
            " email = #{email}, " +
            " update_time = NOW()" +
            " WHERE id = #{id}")
    void update(User user);


    //    更新头像
    @Update("UPDATE user SET user_pic = #{avatarUrl},update_time = NOW() WHERE id = #{id}")
    void updateAvatar(@Param("avatarUrl") String avatarUrl,@Param("id") Integer id);


    //更新密码
    @Update("UPDATE user SET password = #{md5String},update_time = NOW() WHERE id = #{id}")
    void updatePwd(@Param("md5String") String md5String,@Param("id") Integer id);
}
