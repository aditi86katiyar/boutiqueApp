package com.example.boutiqueapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
@ComponentScan(basePackages = "com.example.boutiqueapp")
public class BoutiqueappApplication {

    public static void main(String[] args) {
        SpringApplication.run(BoutiqueappApplication.class, args);
    }

}
