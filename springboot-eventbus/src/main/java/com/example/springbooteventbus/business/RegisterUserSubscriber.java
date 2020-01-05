package com.example.springbooteventbus.business;

import com.google.common.eventbus.Subscribe;
import com.nepxion.eventbus.annotation.EventBus;
import com.nepxion.eventbus.core.EventControllerFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Una Ma
 * @className RegisterUserSyvScriber
 * @description 同步执行注册用户成功后发送邮件
 * @date 2020/1/5 9:31 下午
 **/
@EventBus(async = false)
@Service
@Slf4j
public class RegisterUserSubscriber {

    @Autowired
    private EventControllerFactory eventControllerFactory;

    @Subscribe
    public void subscribe(UserEvent userEvent) {
        log.info("用户注册成功，即将发送邮件，用户名：{}" ,userEvent.getUserName());
        //模拟用户新增失败的
//        int i = 1/0;
        //发送邮件
        eventControllerFactory.getSyncController().post(new EmailEvent(userEvent.getUserName() ,"职业选手"));
    }

    @Subscribe
    public void subscribe(EmailEvent emailEvent) {
        log.info("邮件发送成功：{}" ,emailEvent.getUserName() + "已经成为了" + emailEvent.getMessage());
    }

}
