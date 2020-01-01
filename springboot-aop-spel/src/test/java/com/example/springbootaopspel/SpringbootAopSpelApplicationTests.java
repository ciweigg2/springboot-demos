package com.example.springbootaopspel;

import com.alibaba.fastjson.JSONObject;
import com.example.springbootaopspel.model.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest
@Slf4j
@AutoConfigureMockMvc
class SpringbootAopSpelApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void contextLoads() throws Exception {
        User user = new User();
        user.setUsername("una");
        user.setDepartmentId(13);
        MvcResult result = mockMvc.perform(
                MockMvcRequestBuilders.post("/aop/changeDefaultAccount").contentType(MediaType.APPLICATION_JSON).content(JSONObject.toJSONBytes(user)))
                .andReturn();
        log.info(result.getResponse().getContentAsString());
    }

}
