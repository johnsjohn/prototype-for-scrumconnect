package com.prototype.scrumconnect;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@SpringBootApplication
@EnableMongoAuditing
public class ScrumconnectApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScrumconnectApplication.class, args);
	}

}
