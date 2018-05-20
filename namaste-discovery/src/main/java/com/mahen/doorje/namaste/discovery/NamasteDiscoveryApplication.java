package com.mahen.doorje.namaste.discovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class NamasteDiscoveryApplication {
    public static void main(String[] args) {
        SpringApplication.run(NamasteDiscoveryApplication.class, args);
    }
}
