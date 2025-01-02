package com.seecen.springboot_backendmanagement.controller;

import com.seecen.springboot_backendmanagement.entity.Result;
import com.seecen.springboot_backendmanagement.entity.User;
import com.seecen.springboot_backendmanagement.service.UserService;
import com.seecen.springboot_backendmanagement.utils.JwtUtil;
import com.seecen.springboot_backendmanagement.utils.Md5Util;
import com.seecen.springboot_backendmanagement.utils.ThreadLocalUtil;
import org.hibernate.validator.constraints.URL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.constraints.Pattern;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName UserController
 * @Description TODO
 * @Author aql
 * @Date 2024/12/6 下午5:00
 * @Version 1.0
 **/
@RestController
@RequestMapping("/user")
@Validated
public class UserController {
    @Autowired
    private UserService userService;
    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @PostMapping("/register")
    public Result register(@Pattern(regexp = "^[a-zA-Z0-9_-]{5,16}$", message = "用户名必须是5-16位的字母、数字、下划线、减号") String username,
                           @Pattern(regexp = "^[a-zA-Z0-9]{6,16}$", message = "密码必须是6-16位的字母、数字") String password) {
        //        查询用户
        User u=userService.findUserByUsername(username);
        if (u==null){
//            没有占用        注册
            userService.register(username,password);
            return Result.success();
        }else {
            return Result.error("用户名已被占用");
        }

    }

    @GetMapping("/login")
    public Result login(@RequestParam @Pattern(regexp = "^[a-zA-Z0-9_-]{5,16}$", message = "用户名必须是5-16位的字母、数字、下划线、减号") String username,
                        @RequestParam @Pattern(regexp = "^[a-zA-Z0-9]{6,16}$", message = "密码必须是6-16位的字母、数字") String password) {
        //        查询用户
        User u=userService.findUserByUsername(username);
        if (u!=null) {
//            存在        登录
            if (Md5Util.getMD5String(password).equals(u.getPassword())){
                //登录成功
                HashMap<String, Object> claims = new HashMap<>();
                claims.put("id",u.getId());
                claims.put("username",u.getUsername());

                String token = JwtUtil.genToken(claims);
                //把token存储到redis当中
                ValueOperations<String, String> operations = stringRedisTemplate.opsForValue();
                operations.set(token,token,1, TimeUnit.HOURS);
                return Result.success(token);
            }
        }
      else {
            return Result.error("用户名不存在");
        }
      return Result.error("密码错误");
    }

    @GetMapping("/info")
    public Result<User> userInfo(/*@RequestHeader("Authorization") String token*/){
        //根据用户名查询用户
//        Map<String, Object> map = JwtUtil.parseToken(token);
//        String username = (String) map.get("username");

        Map<String, Object> map = ThreadLocalUtil.get();
        String username = (String) map.get("username");
        User userByUsername = userService.findUserByUsername(username);
        return Result.success(userByUsername);

    }

    @PutMapping("/update")
    public Result update(@Validated @RequestBody User user){
        //更新用户信息
        userService.update(user);

        return Result.success();
    }

    @PatchMapping("/updateAvatar")
    public Result updateAvatar(@Validated  @RequestParam("avatarUrl")  @URL String avatarUrl){
        userService.updateAvatar(avatarUrl);
        return Result.success();
    }


    @PatchMapping("/updatePwd")
    public Result updatePwd(@RequestBody Map<String,String> params,@RequestHeader("Authorization") String token){
        //校验参数
      String oldPwd = params.get("old_Pwd");
      String newPwd = params.get("new_Pwd");
      String rePwd = params.get("re_Pwd");
        //验证是否和原密码一致
        if (!StringUtils.hasLength(oldPwd)||!StringUtils.hasLength(newPwd)||!StringUtils.hasLength(rePwd)){
            return Result.error("缺少必要参数");
        }
        Map<String, Object> map = ThreadLocalUtil.get();
        String username = (String) map.get("username");
        User loginUser = userService.findUserByUsername(username);
        if (!loginUser.getPassword().equals(Md5Util.getMD5String(oldPwd))) {
            return Result.error("原密码错误");
        }
        //验证两次密码是否一致
        if (!newPwd.equals(rePwd)){
            return Result.error("两次密码不一致");
        }
        //调用service完成密码更新
        userService.updatePwd(newPwd);
        //删除redis中对应的token
        ValueOperations<String, String> operations = stringRedisTemplate.opsForValue();
        operations.getOperations().delete(token);
        return Result.success();
    }


}
