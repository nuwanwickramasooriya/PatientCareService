package com.aventude.patientCareService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class PatientCareServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PatientCareServiceApplication.class, args);
	}

}
