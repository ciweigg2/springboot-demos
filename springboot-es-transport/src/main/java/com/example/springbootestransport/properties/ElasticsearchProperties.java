package com.example.springbootestransport.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.io.Serializable;

/**
 * @author Una Ma
 * @className ElasticsearchProperties
 * @description elasticsearch自动装配类
 * @date 2020/1/13 2:51 下午
 **/
@ConfigurationProperties(prefix = "elasticsearch")
@Data
public class ElasticsearchProperties implements Serializable {

    /**
     * 集群地址
     */
    private String ip;

    /**
     * 端口
     */
    private String port;

    /**
     * 连接池
     */
    private String pool;

    /**
     * 集群名
     */
    private String clusterName;

}
