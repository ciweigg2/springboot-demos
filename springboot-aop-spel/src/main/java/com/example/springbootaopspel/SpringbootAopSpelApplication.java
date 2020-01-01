package com.example.springbootaopspel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class SpringbootAopSpelApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootAopSpelApplication.class, args);
	}

}
