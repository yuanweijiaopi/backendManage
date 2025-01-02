package com.seecen.springboot_backendmanagement.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @ClassName PageQuery
 * @Description TODO
 * @Author aql
 * @Date 2024/12/26 16:47
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageQuery<T> {
    //总条数
    private Long total;
    //当前页数据的集合
    private List<T>  items;
}
