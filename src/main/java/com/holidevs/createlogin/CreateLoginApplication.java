package com.holidevs.createlogin;

import com.holidevs.createlogin.AppUser.AppUser;
import com.holidevs.createlogin.AppUser.AppUserRepository;
import com.holidevs.createlogin.AppUser.AppUserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Optional;

@SpringBootApplication
public class CreateLoginApplication implements CommandLineRunner {

	@Autowired
	AppUserRepository appUserRepository;

	public static void main(String[] args) {
		SpringApplication.run(CreateLoginApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		AppUser user = new AppUser(
				"John Doe",            // name
				"johndoe123",          // username
				"johndoe@example.com", // email
				"password123",         // password
				AppUserRole.USER,      // appUserRole
				false,                 // locked
				true                   // enabled
		);
		AppUser user2 = new AppUser(
				"Rob",            // name
				"vetere",          // username
				"rob@example.com", // email
				"password123",         // password
				AppUserRole.USER,      // appUserRole
				false,                 // locked
				true                   // enabled
		);
		appUserRepository.save(user);
		appUserRepository.save(user2);
		Optional<AppUser> optionalUser = appUserRepository.findByEmail(user.getEmail());
		Optional<AppUser> optionalUser2 = appUserRepository.findByEmail(user2.getEmail());
		if (optionalUser.isPresent()) {
			AppUser retrievedUser = optionalUser.get();
			AppUser retrievedUser2 = optionalUser2.get();
			System.out.println(retrievedUser);
			System.out.println(retrievedUser2);
		} else {
			System.out.println("No se encontró ningún usuario con ese correo electrónico.");
		}
	}
}
