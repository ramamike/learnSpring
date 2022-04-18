package com.spring.simple;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SimpleApplication {

	static Logger logger = LoggerFactory.getLogger(SimpleApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(SimpleApplication.class, args);

		logger.info("main is started");

	}

}
