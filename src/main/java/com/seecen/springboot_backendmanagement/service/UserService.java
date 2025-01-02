package com.seecen.springboot_backendmanagement.service;

import com.seecen.springboot_backendmanagement.entity.User;

public interface UserService {
    //根据用户名查找用户
    User findUserByUsername(String username);
    //注册
    void register(String username, String password);

    //更新用户信息
    void update(User user);
    //更新头像
    void updateAvatar(String avatarUrl);
    //更新密码
    void updatePwd(String newPwd);
}
