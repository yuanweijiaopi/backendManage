package com.seecen.springboot_backendmangement.controller;

import com.seecen.springboot_backendmangement.entity.Result;
import com.seecen.springboot_backendmangement.utils.JwtUtil;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @ClassName ArticleController
 * @Description TODO
 * @Author aql
 * @Date 2024/12/9 下午12:02
 * @Version 1.0
 **/
@RestController
@RequestMapping("/article")
public class ArticleController {
    @GetMapping("/list")
    public Result<String>  list(){
//        // 验证token
//        try {
//            Map<String, Object> claims = JwtUtil.parseToken(token);
//        } catch (Exception e) {
//            //http的状态码为401，表示未登录
//            response.setStatus(401);
//            return Result.error("未登录");
//        }

        return Result.success("所有文章的假数据");
    }
}
