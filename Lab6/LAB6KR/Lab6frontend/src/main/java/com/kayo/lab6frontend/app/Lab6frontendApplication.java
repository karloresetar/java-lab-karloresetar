package com.kayo.lab6frontend.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.kayo.lab6frontend"})
public class Lab6frontendApplication {

    public static void main(String[] args) {
        SpringApplication.run(Lab6frontendApplication.class, args);
        System.out.println("Marija bistrica");
    }

}
