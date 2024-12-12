package com.seecen.springboot_backendmangement.controller;

import com.seecen.springboot_backendmangement.entity.Category;
import com.seecen.springboot_backendmangement.entity.Result;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName ArticleController
 * @Description TODO
 * @Author aql
 * @Date 2024/12/9 下午12:02
 * @Version 1.0
 **/
@RestController
@RequestMapping("/article")
@Validated
public class ArticleController {
//    @Autowired
//    private ArticleService articleService;


    @PostMapping("/list")
    public Result<String> addCategory(@RequestBody Category category){
//        // 验证token
//        try {
//            Map<String, Object> claims = JwtUtil.parseToken(token);
//        } catch (Exception e) {
//            //http的状态码为401，表示未登录
//            response.setStatus(401);
//            return Result.error("未登录");
//        }
//        articleService.addCategory();

        return Result.success("所有文章的假数据");
    }


}
