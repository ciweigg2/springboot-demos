package com.example.springbooteventbus;

import com.nepxion.eventbus.annotation.EnableEventBus;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableEventBus
public class SpringbootEventbusApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootEventbusApplication.class, args);
    }

}
