package com.gamesys.timetravel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication
public class TimeTravelApplication {

	public static void main(String[] args) {

		SpringApplication.run(TimeTravelApplication.class, args);
	}

}

