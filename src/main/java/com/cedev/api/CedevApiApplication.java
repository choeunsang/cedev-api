package com.cedev.api;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.cedev.api")
@SpringBootApplication
public class CedevApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CedevApiApplication.class, args);
	}
}