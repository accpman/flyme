package com.flyme.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * @author: flyme  
 * @date: 2018/3/7 10:07
 * @desc: 
 */  
@SpringBootApplication(scanBasePackages = "com.flyme")
public class FlymeWebApplication {
    public static void main(String[] args) {
        SpringApplication.run(FlymeWebApplication.class, args);
    }
}
