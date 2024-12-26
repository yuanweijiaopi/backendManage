package com.seecen.springboot_backendmangement.anno;

import com.seecen.springboot_backendmangement.validation.StateValidation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

//元注解
@Documented
//标注可以用在什么地方
@Target({ElementType.FIELD})
// 指定注解在运行时保留
@Retention(RetentionPolicy.RUNTIME)
//指定提供校验规则的类
@Constraint(validatedBy = {StateValidation.class})
public @interface State {

    //提供校验失败后的提示信息
    String message() default "state参数的值只能是已发布或者草稿";

    //指定分组
    Class<?>[] groups() default {};

    //负载 获取到state注解的附加信息
    Class<? extends Payload>[] payload() default {};
}
