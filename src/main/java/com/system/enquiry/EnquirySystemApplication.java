package com.system.enquiry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.system.enquiry")
public class EnquirySystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(EnquirySystemApplication.class, args);
	}
}
