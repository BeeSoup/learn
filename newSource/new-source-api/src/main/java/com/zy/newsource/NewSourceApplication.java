package com.zy.newsource;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.zy.newsource.pojo.datasource.dao")
public class NewSourceApplication {

	public static void main(String[] args) {
		SpringApplication.run(NewSourceApplication.class, args);
	}

}
