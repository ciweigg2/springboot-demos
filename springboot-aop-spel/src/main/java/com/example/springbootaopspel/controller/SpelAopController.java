package com.example.springbootaopspel.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.springbootaopspel.annotation.SpelLog;
import com.example.springbootaopspel.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author maxiucheng
 * @className SpelAopController
 * @description
 * @date 2020/1/1 1:15 下午
 * @menu
 **/
@RestController
@RequestMapping(value = "/aop")
@Slf4j
public class SpelAopController {

    @SpelLog("'会员'+#user.username+'在部门'+#user.departmentId+'送咖啡'")
    @PostMapping(value = "/changeDefaultAccount")
    public void changeDefaultAccount(@RequestBody User user) {
        log.info(JSONObject.toJSONString(user));
    }

}
