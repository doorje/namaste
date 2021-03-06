package com.mahen.doorje.namaste.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class NamasteClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(NamasteClientApplication.class);
    }
}
