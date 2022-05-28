package com.example.reactive_demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ReactiveDemoApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(ReactiveDemoApplication.class, args);

        GreetingClient greetingClient = context.getBean(GreetingClient.class);
        System.out.println(">> message = " + greetingClient.getMessage().block());
    }
}
