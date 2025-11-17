package com.example.userprofile;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class UserprofileApplication {

    @PersistenceContext
    private EntityManager entityManager;

    public static void main(String[] args) {
        SpringApplication.run(UserprofileApplication.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void onApplicationReady() {
        try {
            // Test DB connection
            entityManager.createNativeQuery("SELECT 1").getSingleResult();
            System.out.println(" Application started successfully AND connected to the database!");
        } catch (Exception e) {
            System.err.println(" Application started, but database connection failed! ");
            e.printStackTrace();
        }
    }
}

