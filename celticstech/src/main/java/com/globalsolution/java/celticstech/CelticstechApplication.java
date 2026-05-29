package com.globalsolution.java.celticstech;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class CelticstechApplication {
    public static void main(String[] args) {
        SpringApplication.run(CelticstechApplication.class, args);
    }
}
