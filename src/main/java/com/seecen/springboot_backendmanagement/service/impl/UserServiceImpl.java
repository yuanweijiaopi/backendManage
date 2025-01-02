package com.seecen.springboot_backendmanagement.service.impl;

import com.seecen.springboot_backendmanagement.entity.User;
import com.seecen.springboot_backendmanagement.mapper.UserMapper;
import com.seecen.springboot_backendmanagement.service.UserService;
import com.seecen.springboot_backendmanagement.utils.Md5Util;
import com.seecen.springboot_backendmanagement.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @ClassName UserServiceImpl
 * @Description TODO
 * @Author aql
 * @Date 2024/12/6 下午5:01
 * @Version 1.0
 **/
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User findUserByUsername(String username) {
        return userMapper.findUserByUsername(username);
    }

    @Override
    public void register(String username, String password) {
//        加密
        String md5String = Md5Util.getMD5String(password);
//         保存到数据库
        userMapper.add(username, md5String);
    }

    @Override
    public void update(User user) {
        userMapper.update(user);
    }

    @Override
    public void updateAvatar(String avatarUrl) {
        Map<String, Object> map = ThreadLocalUtil.get();
        Integer id = (Integer) map.get("id");
        userMapper.updateAvatar(avatarUrl, id);
    }

    @Override
    public void updatePwd(String newPwd) {
        Map<String, Object> map = ThreadLocalUtil.get();
        Integer id = (Integer) map.get("id");
        userMapper.updatePwd(Md5Util.getMD5String(newPwd),id);

    }
}
