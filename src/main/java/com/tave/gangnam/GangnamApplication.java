package com.tave.gangnam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.tave.gangnam.week2.assignment.Entity")
public class GangnamApplication {

	public static void main(String[] args) {
		SpringApplication.run(GangnamApplication.class, args);
	}

}
