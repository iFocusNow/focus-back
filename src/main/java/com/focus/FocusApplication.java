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
			AuthorityRepository authorityRepository,
			UserRepository userRepository
	) {
		return args -> {
			// Create a couple of Authority
			authorityRepository.saveAll(List.of(
						new Authority(AuthorityName.ROLE_ADMIN),
						new Authority(AuthorityName.ROLE_PARENT),
						new Authority(AuthorityName.READ),
						new Authority(AuthorityName.WRITE)
					)
			);

			userRepository.save(new User("avi@admin.com", new BCryptPasswordEncoder().encode("pass"), true, new Date(),
					List.of(
							authorityRepository.findByName(AuthorityName.ROLE_ADMIN),
							authorityRepository.findByName(AuthorityName.READ),
							authorityRepository.findByName(AuthorityName.WRITE)
					)
				)
			);
			userRepository.save(new User("john@parent.com", new BCryptPasswordEncoder().encode("pass"), true, new Date(),
							List.of(
									authorityRepository.findByName(AuthorityName.ROLE_PARENT),
									authorityRepository.findByName(AuthorityName.READ),
									authorityRepository.findByName(AuthorityName.WRITE)
							)
					)
			);
			userRepository.save(new User("mary@parent.com", new BCryptPasswordEncoder().encode("pass"), true, new Date(),
							List.of(
									authorityRepository.findByName(AuthorityName.ROLE_PARENT),
									authorityRepository.findByName(AuthorityName.READ),
									authorityRepository.findByName(AuthorityName.WRITE)
							)
					)
			);
		};
	}
}
