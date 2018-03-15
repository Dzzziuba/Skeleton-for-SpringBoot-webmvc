package com.example.testweb;

import com.example.testweb.DAO.repository.HumanRepository;
import com.example.testweb.domain.Human;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TestwebApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestwebApplication.class, args);
	}


	@Bean
	public CommandLineRunner beans(HumanRepository repository){
		return args -> {
			repository.save(new Human("Roma", "Dziuba"));
			repository.save(new Human("Sasha", "Chumak"));
			repository.save(new Human("Nikita", "Vorokhta"));
		};
	}
}
