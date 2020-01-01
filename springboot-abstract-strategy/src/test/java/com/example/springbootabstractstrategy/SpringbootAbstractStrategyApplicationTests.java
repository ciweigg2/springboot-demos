package com.example.springbootabstractstrategy;

import com.example.springbootabstractstrategy.strategy.DataBaseQuery;
import com.example.springbootabstractstrategy.strategy.DataBaseQueryContext;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootAbstractStrategyApplicationTests {

	@Autowired
	private DataBaseQueryContext dataBaseQueryContext;

	@Test
	void contextLoads() {
		//测试内置的Mysql
		DataBaseQuery mysql = dataBaseQueryContext.build("Mysql");
		//测试内置的Oracle
		DataBaseQuery oracle = dataBaseQueryContext.build("Oracle");
		//测试自定义
		DataBaseQuery custom = dataBaseQueryContext.build("Custom");
		mysql.executeSql("select * from una");
		oracle.executeSql("select * from una");
		custom.executeSql("select * from una");
	}

}
