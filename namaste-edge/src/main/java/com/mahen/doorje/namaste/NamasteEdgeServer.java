package com.mahen.doorje.namaste;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class NamasteEdgeServer {
    public static void main(String[] args) {
        SpringApplication.run(NamasteEdgeServer.class, args);
    }
}
