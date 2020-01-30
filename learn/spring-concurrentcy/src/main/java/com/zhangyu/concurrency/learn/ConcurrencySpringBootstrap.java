package com.zhangyu.concurrency.learn;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * 高并发相关学习
 */
@SpringBootApplication
public class ConcurrencySpringBootstrap {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = new SpringApplicationBuilder(ConcurrencySpringBootstrap.class)
				.build(args)
				.run();
	}

}
