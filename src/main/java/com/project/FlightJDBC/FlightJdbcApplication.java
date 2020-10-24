package com.project.FlightJDBC;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class FlightJdbcApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlightJdbcApplication.class, args);
	}

}
