package com.example.hotelservicebackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.bind.annotation.CrossOrigin;

@EnableMongoRepositories
@CrossOrigin("*")
@SpringBootApplication
public class HotelServiceBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotelServiceBackendApplication.class, args);
	}

}
