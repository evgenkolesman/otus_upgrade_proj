package com.example.hw01gradle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Hw01GradleApplication {

	public static void main(String[] args) {
		SpringApplication.run(Hw01GradleApplication.class, args);
		new HelloOtus().guavaMethod();

	}

}
