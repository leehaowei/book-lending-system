package com.leehaowei.booklendingsystem;

import com.github.javafaker.Faker;
import com.leehaowei.booklendingsystem.appuser.AppUser;
import com.leehaowei.booklendingsystem.appuser.AppUserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BookLendingSystemApplication {

	public static void main(String[] args) {

		SpringApplication.run(BookLendingSystemApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(AppUserRepository userRepository) {
		return args -> {
			Faker faker = new Faker();
			AppUser user = new AppUser(
					faker.phoneNumber().subscriberNumber(10),
					faker.number().digits(10),
					faker.name().fullName()
			);
			userRepository.save(user);
		};
	}
}
