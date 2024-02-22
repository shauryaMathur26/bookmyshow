package com.scaler.bookmyshow;

import com.scaler.bookmyshow.controllers.UserController;
import com.scaler.bookmyshow.dtos.SignUpRequestDTO;
import com.scaler.bookmyshow.dtos.SignUpResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@SpringBootApplication
@EnableJpaAuditing // Gives info about createdOn,lastModifiedAt
public class BookmyshowApplication implements CommandLineRunner {

	@Autowired
	private UserController userController;

	@Override
	public void run(String... args) throws Exception {
		SignUpRequestDTO signUpRequestDTO = SignUpRequestDTO.builder().
				email("sm3@scaler.com")
				.password("1234").build();
		SignUpResponseDTO responseDTO = userController.signUp(signUpRequestDTO);
	}

	public static void main(String[] args) {
		SpringApplication.run(BookmyshowApplication.class, args);
	}

	//TODO ::
	// accessors(chain=true) [LOMBOK]
	//TODO :: @Configuration, @Component, @Controller, @ Service, @Repository and @Qualifier
	// BCrypt Password Encryption

}
