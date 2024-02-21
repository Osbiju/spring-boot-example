package com.amigoscode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication //tiene dentro las anotaciones componentscan, enableautoconfig y config
//@ComponentScan(basePackages = "com.amigoscode") //to tell the package that have to look for
//@EnableAutoConfiguration
//@Configuration //to instantiate bin configurtations
@RestController
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @GetMapping("/greet")
    public String greet(){
        return "Hello";
    }
}
