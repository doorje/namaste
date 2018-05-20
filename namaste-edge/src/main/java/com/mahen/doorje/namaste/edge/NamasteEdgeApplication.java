package com.mahen.doorje.namaste.edge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class NamasteEdgeApplication {
    public static void main(String[] args) {
        SpringApplication.run(NamasteEdgeApplication.class, args);
    }
}
