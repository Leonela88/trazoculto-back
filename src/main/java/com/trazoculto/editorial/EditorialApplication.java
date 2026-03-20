package com.trazoculto.editorial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class EditorialApplication {

	public static void main(String[] args) {
		SpringApplication.run(EditorialApplication.class, args);
	}

}
