package com.seecen.springboot_backendmangement.validation;

import com.seecen.springboot_backendmangement.anno.State;
import net.sf.jsqlparser.statement.alter.ConstraintState;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @ClassName StateValidation
 * @Description TODO
 * @Author aql
 * @Date 2024/12/26 14:44
 * @Version 1.0
 **/
// ConstraintValidator 中应该给连个泛型，第一个参数是"给哪个注解提供校验规则，校验的数据类型"
public class StateValidation implements ConstraintValidator<State,String> {

    /**@Description: TODO methods
     * @param s 将来要校验的数据
     * @return 如果返回的是false，则说明校验不通过
     */
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        //提供校验规则
        if (s == null){
            return false;
        }
        if (s.equals("已发布") || s.equals("草稿")){
            return true;
        }
        return false;
    }
}
