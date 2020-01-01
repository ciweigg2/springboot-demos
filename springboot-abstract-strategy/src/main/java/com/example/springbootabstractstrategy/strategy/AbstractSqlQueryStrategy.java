package com.example.springbootabstractstrategy.strategy;


import lombok.extern.slf4j.Slf4j;

/**
 * 抽象的Sql查询策略
 *
 * @author maxiucheng
 * @date 2019/12/27 16:19:19
 */
@Slf4j
public abstract class AbstractSqlQueryStrategy implements DataBaseQuery {

    protected abstract String getDriverName();

    /**
     * 这边可以做一些文章 这边只是提供例子 并不做具体操作
     *
     * @param sql 执行sql
     */
    @Override
    public void executeSql(String sql) {
        //获取驱动类型
        String driverName = getDriverName();
        log.info("驱动类型：" + driverName);
        //执行自定义sql
        log.info("执行自定义sql");
    }

}