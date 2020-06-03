package com.demo.spring.beans.lifecycles;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringBeansLifeCyclesDemoApplication {

	public static void main(String[] args) throws InterruptedException {

		ConfigurableApplicationContext run = SpringApplication.run(SpringBeansLifeCyclesDemoApplication.class, args);
		Thread.sleep(5000);
		run.stop();
	}

}
