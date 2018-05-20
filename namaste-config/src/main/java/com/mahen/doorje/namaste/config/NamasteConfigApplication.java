package com.mahen.doorje.namaste.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class NamasteConfigApplication {
    public static void main(String[] args) {
        SpringApplication.run(NamasteConfigApplication.class, args);
    }
}
