package com.example.springbootestransport.util;

import com.example.springbootestransport.properties.ElasticsearchProperties;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.InetAddress;

/**
 * @author Una Ma
 * @className ElasticsearchConfig
 * @description es配置类
 * @date 2020/1/12 5:35 下午
 **/
@Configuration
@Slf4j
public class ElasticsearchConfig {

    @Autowired
    private ElasticsearchProperties elasticsearchProperties;

    /**
     * Bean name default  函数名字
     * @return
     */
    @Bean
    public TransportClient transportClient() {
        log.info("Elasticsearch初始化开始。。。。。");
        TransportClient transportClient = null;
        try {
            // 配置信息
            Settings esSetting = Settings.builder()
                    .put("cluster.name", elasticsearchProperties.getClusterName()) //集群名字
                    .put("client.transport.sniff", false)
                    .put("thread_pool.search.size", Integer.parseInt(elasticsearchProperties.getPool()))//增加线程池个数，暂时设为5
                    .build();
            //配置信息Settings自定义
            transportClient = new PreBuiltTransportClient(esSetting);
            TransportAddress transportAddress = new TransportAddress(InetAddress.getByName(elasticsearchProperties.getIp()), Integer.valueOf(elasticsearchProperties.getPort()));
            transportClient.addTransportAddresses(transportAddress);
        } catch (Exception e) {
            log.error("elasticsearch TransportClient create error!!", e);
        }
        return transportClient;
    }

}