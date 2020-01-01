package com.example.springbootabstractstrategy.autoconfiguration;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author maxiucheng
 * @className StrategyAutoConfiguration
 * @description 自定装配
 * @date 2020/1/1 11:25 上午
 **/
@Configuration
public class StrategyAutoConfiguration {

    /**
     * 当customDriverQuery bean不存在的时候加载当前bean
     *
     * @return customDriverQuery
     */
    @Bean
    @ConditionalOnMissingBean
    public CustomDriverQuery ymlCustomDriverQuery(){
        return new YmlCustomDriverQuery();
    }

    /**
     * 不提供重写
     *
     * @return customQueryStrategy
     */
    @Bean(name = "Custom")
    public CustomQueryStrategy customQueryStrategy(CustomDriverQuery customDriverQuery){
        return new CustomQueryStrategy(customDriverQuery);
    }

}
