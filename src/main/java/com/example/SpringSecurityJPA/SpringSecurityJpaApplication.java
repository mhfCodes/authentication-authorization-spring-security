package com.example.SpringSecurityJPA;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.SpringSecurityJPA.models.User;
import com.example.SpringSecurityJPA.repository.UserRepository;

@SpringBootApplication
public class SpringSecurityJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityJpaApplication.class, args);
	}
	
	@Bean
	CommandLineRunner run(UserRepository userRepository) {
		return args -> {
			User john = new User("john", "1234", true, "ROLE_USER");
			User david = new User("david", "1234", false, "ROLE_ADMIN");
			User alex = new User("alex", "1234", true, "ROLE_ADMIN");
			
			userRepository.saveAll(List.of(john, david, alex));
		};
	}
	

}
