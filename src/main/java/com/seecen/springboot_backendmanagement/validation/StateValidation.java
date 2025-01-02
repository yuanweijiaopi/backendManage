package com.seecen.springboot_backendmanagement.validation;

import com.seecen.springboot_backendmanagement.anno.State;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @ClassName Context
 * @Description TODO
 * @Author aql
 * @Date 2024/12/26 14:44
 * @Version 1.0
 **/
// ConstraintValidator 中应该给连个泛型，第一个参数是"给哪个注解提供校验规则，校验的数据类型"
public class StateValidation implements ConstraintValidator<State,String> {

    /**@Description: TODO methods
     * @param value 将来要校验的数据
     * @return 如果返回的是false，则说明校验不通过
     */
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        //提供校验规则
        if (value == null){
            return false;
        }
        if (value.equals("已发布") || value.equals("草稿")){
            return true;
        }
        return false;
    }
}
