package com.example.publishingservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@SpringBootApplication

public class PublishingServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(PublishingServiceApplication.class, args);
    }

}
