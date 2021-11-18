package com.test.trading;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class DBCodingTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(DBCodingTestApplication.class, args);
	}

}
