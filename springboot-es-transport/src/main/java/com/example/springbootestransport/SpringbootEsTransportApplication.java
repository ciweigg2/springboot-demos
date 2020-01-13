package com.example.springbootestransport;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class SpringbootEsTransportApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootEsTransportApplication.class, args);
	}

}
