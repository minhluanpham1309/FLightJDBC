package com.project.FlightJDBC;

//<editor-fold defaultstate="collapsed" desc="comment">
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
//</editor-fold>

@SpringBootApplication
@EnableCaching
public class FlightJdbcApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlightJdbcApplication.class, args);
	}

}
