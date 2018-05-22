package com.mahen.doorje.namaste.service.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

@SpringBootApplication
@RestController
public class NamasteUserServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(NamasteUserServiceApplication.class, args);
    }

    @RequestMapping({"/"})
    @ResponseBody
    public Map<String, String> user(Principal principal) {
        Map<String, String> map = new LinkedHashMap<>();
        map.put("name", principal.getName());
        return map;
    }

    @RequestMapping({"/profile"})
    @ResponseBody
    public Map<String, String> profile(Principal principal) {
        Map<String, String> map = new LinkedHashMap<>();
        map.put("name", principal.getName());
        return map;
    }

    @RequestMapping("/message")
    public Message message() {
        return new Message("Namaste from Sarangkot!");
    }
}

class Message {
    private String id = UUID.randomUUID().toString();
    private String content;

    public Message() {}

    public Message(String content) {
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}