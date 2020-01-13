package com.example.springbootestransport.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Una Ma
 * @className Employee
 * @description 加上了@Document注解之后，默认情况下这个实体中所有的属性都会被建立索引、并且分词
 * @date 2020/1/13 2:17 下午
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    private String id;
    private Long version;
    String firstName;
    String lastName;
    String age;
    String[] interests;
}
