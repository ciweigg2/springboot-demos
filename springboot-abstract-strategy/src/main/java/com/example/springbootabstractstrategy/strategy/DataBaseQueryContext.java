package com.example.springbootabstractstrategy.strategy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 数据库查询上下文
 *
 * @author maxiucheng
 * @date 2019/12/27 16:19:00
 */
@Component
public class DataBaseQueryContext {

    @Autowired
    private Map<String, DataBaseQuery> contextStrategy = new ConcurrentHashMap<>();

    public DataBaseQuery build(String type) {
        return contextStrategy.get(type);
    }

}
