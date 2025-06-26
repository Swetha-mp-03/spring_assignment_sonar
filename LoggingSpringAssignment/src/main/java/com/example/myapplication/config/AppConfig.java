package com.example.myapplication.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.example.myapplication")
public class AppConfig {
    // Additional configurations (e.g., bean definitions) can go here
}
