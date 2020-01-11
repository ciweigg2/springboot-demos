package com.example.springbootredis;

import com.alibaba.fastjson.JSONObject;
import com.example.springbootredis.model.User;
import com.example.springbootredis.utils.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@SpringBootTest
@Slf4j
class SpringbootRedisApplicationTests {

	@Autowired
	private RedisUtil redisUtil;

	@Test
	void contextLoads() {
		redisUtil.set("una" ,"测试1");
		User user = new User();
		user.setId(0);
		user.setDepartmentId(0);
		user.setUsername("Una");
		user.setGender("男");
		user.setIsDeleted((byte)0);
		user.setCreateTime(new Date());
		List<User> userList = Arrays.asList(user);
		redisUtil.putListCacheWithExpireTime("userLists" ,userList ,3600);
		List<User> userLists = redisUtil.getListCache("userLists", User.class);
		log.info("反序列化的用户列表：" + JSONObject.toJSONString(userLists));
	}

}
