package com.example.springbootabstractstrategy.strategy;

import org.springframework.stereotype.Component;

/**
 * Oracle的查询策略 内置的
 *
 * @author maxiucheng
 * @date 2019/12/27 16:18:34
 */
@Component(value = "Oracle")
public class OracleQueryStrategy extends AbstractSqlQueryStrategy {

    private static String DRIVER = "oracle.jdbc.OracleDriver";

    @Override
    protected String getDriverName() {
        return DRIVER;
    }

}
