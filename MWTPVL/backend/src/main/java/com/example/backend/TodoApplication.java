package com.example.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;

//import com.example.backend.SpringBootApplication;
import com.example.backend.TodoApplication;

@SpringBootConfiguration
public class TodoApplication {

    public static void main(String[] args) {
        SpringApplication.run(TodoApplication.class, args);
    }
}