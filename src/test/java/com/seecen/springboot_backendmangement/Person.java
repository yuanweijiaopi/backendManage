package com.seecen.springboot_backendmangement;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName Person
 * @Description TODO
 * @Author aql
 * @Date 2024/12/24 14:53
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    private String Name;

    private Integer salary;

    private Integer Age;

    private String Gender;

    private String Address;

    public static int compareByAge(Person a, Person b){
        return a.getAge().compareTo(b.getAge());
    }
}
