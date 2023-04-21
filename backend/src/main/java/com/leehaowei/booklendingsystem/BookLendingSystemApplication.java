package com.leehaowei.booklendingsystem;

import com.github.javafaker.Faker;
import com.leehaowei.booklendingsystem.appuser.AppUser;
import com.leehaowei.booklendingsystem.appuser.AppUserRepository;
import com.leehaowei.booklendingsystem.book.Book;
import com.leehaowei.booklendingsystem.book.BookRepository;
import com.leehaowei.booklendingsystem.inventory.Inventory;
import com.leehaowei.booklendingsystem.inventory.InventoryRepository;
import com.leehaowei.booklendingsystem.inventory.InventoryStatus;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.jdbc.core.JdbcTemplate;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.time.LocalDateTime;


@SpringBootApplication
public class BookLendingSystemApplication {

	public static void main(String[] args) {

		SpringApplication.run(BookLendingSystemApplication.class, args);
	}

	// add fake user data
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

	// add fake book and inventory data
	@Bean
	CommandLineRunner addFakeDataToInventoryAndBook(InventoryRepository inventoryRepository, BookRepository bookRepository) {
		return args -> {
			Faker faker = new Faker();

			for (int i = 0; i < 50; i++) {
				Book book = new Book();
				String fakeIsbn = faker.number().digits(13);

				book.setIsbn(fakeIsbn);
				book.setName(faker.book().title());
				book.setAuthor(faker.book().author());
				bookRepository.save(book);

				Inventory inventory = new Inventory();
				inventory.setIsbn(fakeIsbn);
				inventory.setStatus(faker.options().option(InventoryStatus.values()));
				inventory.setStoreTime(LocalDateTime.now());
				inventoryRepository.save(inventory);
			}
		};
	}
}
