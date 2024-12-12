package com.seecen.springboot_backendmangement.config;

import com.seecen.springboot_backendmangement.interceptors.LoginInterceptors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @ClassName WebConfig
 * @Description TODO
 * @Author aql
 * @Date 2024/12/9 下午5:19
 * @Version 1.0
 **/
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private LoginInterceptors loginInterceptors;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //登录接口和注册接口不拦截
        registry.addInterceptor(loginInterceptors).excludePathPatterns("/user/login", "/user/register");
    }
}
