package com.example.testweb;

import com.example.testweb.DAO.repository.HumanRepository;
import com.example.testweb.domain.Human;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

import javax.servlet.ServletContext;

@SpringBootApplication
public class TestwebApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestwebApplication.class, args);
    }


    @Bean
    public CommandLineRunner beans(HumanRepository repository) {
        return args -> {
            repository.save(new Human("Roma", "Dziuba"));
            repository.save(new Human("Sasha", "Chumak"));
            repository.save(new Human("Nikita", "Vorokhta"));
        };
    }
}
