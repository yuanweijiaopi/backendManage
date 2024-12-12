package com.seecen.springboot_backendmangement.interceptors;

import com.seecen.springboot_backendmangement.entity.Result;
import com.seecen.springboot_backendmangement.utils.JwtUtil;
import com.seecen.springboot_backendmangement.utils.ThreadLocalUtil;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @ClassName LoginInterceptors
 * @Description TODO
 * @Author aql
 * @Date 2024/12/9 下午5:15
 * @Version 1.0
 **/
@Component
public class LoginInterceptors implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //令牌验证
        String token = request.getHeader("Authorization");
        // 验证token
        try {
            Map<String, Object> claims = JwtUtil.parseToken(token);

            //把业务数据存储到LocalThread中
            ThreadLocalUtil.set(claims);
            //放行
            return true;
        } catch (Exception e) {
            //http的状态码为401，表示未登录
            response.setStatus(401);
            //不放行
            return false;
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        ThreadLocalUtil.remove();
    }
}
