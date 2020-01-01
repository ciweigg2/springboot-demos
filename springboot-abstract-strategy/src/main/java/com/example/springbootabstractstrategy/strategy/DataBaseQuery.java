package com.example.springbootabstractstrategy.strategy;

/**
 * 数据库查询
 *
 * @author maxiucheng
 * @date 2019/12/27 16:19:08
 */
public interface DataBaseQuery {

    /**
     * 具体的sql查询
     *
     * @param sql
     * @return
     */
    void executeSql(String sql);

}