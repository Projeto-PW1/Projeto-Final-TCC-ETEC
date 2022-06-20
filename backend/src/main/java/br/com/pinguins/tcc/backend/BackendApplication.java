package br.com.pinguins.tcc.backend;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.time.LocalDateTime;
import java.time.LocalTime;

@RestController
@SpringBootApplication
public class BackendApplication implements WebMvcConfigurer{
    public static void main(String[] args) {
        SpringApplication.run(BackendApplication.class, args);


        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/usuarios/**")
                .allowedMethods("*")
                .allowedOrigins("*");
    }
}
