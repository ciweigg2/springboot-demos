package com.example.springbootredis.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @author maxiucheng
 * @className User
 * @description
 * @date 2019/12/21 4:05 下午
 * @menu
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    /**
     * ID
     */
    private Integer id;

    private Integer departmentId;

    private String username;

    private String gender;

    private Byte isDeleted;

    /**
     * 创建时间
     */
    private Date createTime;

}