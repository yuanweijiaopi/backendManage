package com.seecen.springboot_backendmanagement.interceptors;

import com.seecen.springboot_backendmanagement.utils.JwtUtil;
import com.seecen.springboot_backendmanagement.utils.ThreadLocalUtil;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.annotation.Resource;
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
    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //令牌验证
        String token = request.getHeader("Authorization");
        // 验证token
        try {
            //从redis当中获取相同的redis
            ValueOperations<String, String> operations = stringRedisTemplate.opsForValue();
            String redisToken = operations.get(token);
            if (redisToken == null) {
                //token已经失效了
                throw new RuntimeException();
            }

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
