package com.example.springbooteventbus.business;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Una Ma
 * @className EmailEvent
 * @description 邮件监听对象
 * @date 2020/1/5 9:28 下午
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmailEvent implements Serializable {

    /**
     * 用户名
     */
    private String userName;

    /**
     * 消息
     */
    private String message;

}
