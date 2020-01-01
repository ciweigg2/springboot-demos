package com.example.springbootabstractstrategy.autoconfiguration;

import com.example.springbootabstractstrategy.strategy.AbstractSqlQueryStrategy;
import lombok.Setter;

/**
 * @author maxiucheng
 * @className CustomQueryStrategy
 * @description 自定义查询策略
 * @date 2020/1/1 11:13 上午
 **/
public class CustomQueryStrategy extends AbstractSqlQueryStrategy {

    @Setter
    private CustomDriverQuery customDriverQuery;

    public CustomQueryStrategy(CustomDriverQuery customDriverQuery) {
        this.customDriverQuery = customDriverQuery;
    }

    @Override
    protected String getDriverName() {
        return customDriverQuery.queryDriver();
    }

}
