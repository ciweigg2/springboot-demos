package com.example.springbootabstractstrategy.autoconfiguration;

import com.example.springbootabstractstrategy.utils.YmlUtils;

/**
 * @author maxiucheng
 * @className YmlCustomDriverQuery
 * @description 默认实现从yml中获取driver
 * @date 2020/1/1 11:19 上午
 **/
public class YmlCustomDriverQuery implements CustomDriverQuery {

    private static final String DRIVER_KEY = "custom.datasource.driver";

    @Override
    public String queryDriver() {
        return String.valueOf(YmlUtils.getCommonYml(DRIVER_KEY));
    }

}
