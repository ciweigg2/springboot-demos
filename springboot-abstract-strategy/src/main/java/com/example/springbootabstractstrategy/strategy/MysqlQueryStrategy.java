package com.example.springbootabstractstrategy.strategy;

import org.springframework.stereotype.Component;

/**
 * Mysql查询策略 内置的
 *
 * @author maxiucheng
 * @date 2019/12/27 16:18:45
 */
@Component(value = "Mysql")
public class MysqlQueryStrategy extends AbstractSqlQueryStrategy {

    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";

    @Override
    protected String getDriverName() {
        return DRIVER;
    }

}
