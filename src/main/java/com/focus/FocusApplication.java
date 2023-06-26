package com.focus;

import com.focus.model.Authority;
import com.focus.model.AuthorityName;
import com.focus.model.User;
import com.focus.repository.AuthorityRepository;
import com.focus.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Date;
import java.util.List;

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

