package com.example.publishingservice;

import com.example.publishingservice.configuration.CorsConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@SpringBootApplication
public class PublishingServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(PublishingServiceApplication.class, args);
    }
    @Bean
    public CorsConfig addCorsMapping() {
        return new CorsConfig() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("http://localhost", "http://localhost:8080", "http://212.193.62.200:8080", "http://localhost:5173")
                        .allowedMethods("GET", "POST", "PUT", "DELETE")
                        .allowCredentials(true)
                        .maxAge(3600);
            }
        };
    }

}
