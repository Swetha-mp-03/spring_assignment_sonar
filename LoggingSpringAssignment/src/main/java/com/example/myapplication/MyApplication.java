package com.example.myapplication;

import com.example.myapplication.config.AppConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MyApplication {
    private static final Logger logger = LoggerFactory.getLogger(MyApplication.class);

    public static void main(String[] args) {
        // Explicitly declare the type of the context variable
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class)) {
            logger.info("Application started successfully.");
        } catch (Exception e) {
            logger.error("Application failed to start: {}", e.getMessage(), e);
        }
    }
}
