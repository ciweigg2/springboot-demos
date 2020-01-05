package com.example.springbooteventbus;

import com.example.springbooteventbus.business.RegisterUserPublisher;
import com.example.springbooteventbus.test.MyPublisher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootEventbusApplicationTests {

    @Autowired
    private MyPublisher myPublisher;

    @Autowired
    private RegisterUserPublisher registerUserPublisher;

    @Test
    void contextLoads() {
//        myPublisher.publish();
        registerUserPublisher.publish();
    }

}
