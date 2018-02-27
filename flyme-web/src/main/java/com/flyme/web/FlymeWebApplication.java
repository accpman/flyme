package com.flyme.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.flyme")
public class FlymeWebApplication {
    public static void main(String[] args) {
        SpringApplication.run(FlymeWebApplication.class, args);
    }
}
