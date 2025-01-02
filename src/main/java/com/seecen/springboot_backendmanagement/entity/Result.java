package com.seecen.springboot_backendmanagement.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName Result
 * @Description TODO
 * @Author aql
 * @Date 2024/12/6 下午4:45
 * @Version 1.0
 **/
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Result<T> {
    //业务转换码 0-成功 1-失败
    private Integer code;
    //提示信息
    private String message;
//    响应数据
    private T data;

    //快速返回操作成功响应结果（带响应数据）
    public static <T> Result<T> success(T data) {
        return new Result<T>(0, "操作成功", data);
    }

    //快速返回操作成功响应结果（不带响应数据）
    public static <T> Result<T> success() {
        return new Result<T>(0, "操作成功", null);
    }

    //快速返回操作失败响应结果（带提示信息）
    public static <T> Result<T> error(String message) {
        return new Result<T>(1, message, null);
    }


}
