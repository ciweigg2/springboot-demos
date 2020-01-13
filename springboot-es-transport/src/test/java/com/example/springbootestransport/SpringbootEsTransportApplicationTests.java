package com.example.springbootestransport;

import com.alibaba.fastjson.JSONObject;
import com.example.springbootestransport.util.ElasticsearchUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootEsTransportApplicationTests {

    @Test
    void contextLoads() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("新增数据呀", "Una Ma");
        ElasticsearchUtils.addData(jsonObject, "una", "mt");
    }

}
