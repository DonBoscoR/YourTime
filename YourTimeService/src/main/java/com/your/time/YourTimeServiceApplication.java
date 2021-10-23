package com.your.time;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class YourTimeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(YourTimeServiceApplication.class, args);
	}

}
