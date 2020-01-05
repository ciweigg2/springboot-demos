package com.example.springbooteventbus.business;

import com.nepxion.eventbus.core.EventControllerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Una Ma
 * @className RegisterUserPublisher
 * @description 注册用户并且发送邮件呀
 * @date 2020/1/5 9:35 下午
 **/
@Service
public class RegisterUserPublisher {

    @Autowired
    private EventControllerFactory eventControllerFactory;

    public void publish() {
        // 同步模式下，主线程中收到派发的事件
        // 事件派发接口中eventControllerFactory.getSyncController(identifier)必须和@EventBus参数保持一致，否则会收不到事件
        //注册用户
        String userName = "Una";
        eventControllerFactory.getSyncController().post(new UserEvent(userName));
        //发送邮件
//        eventControllerFactory.getSyncController().post(new EmailEvent(userName ,"职业选手"));
    }

}
