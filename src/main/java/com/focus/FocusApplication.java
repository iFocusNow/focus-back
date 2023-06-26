package com.focus;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EntityScan("com.focus.model")
public class FocusApplication {
	public static void main(String[] args) {
		SpringApplication.run(FocusApplication.class, args);
	}

	@Bean
	public CommandLineRunner mappingDemo(
	) {
		return args -> {
		};
	}
}

