package com.mahen.doorje.namaste.client.api.namaste;

import com.mahen.doorje.namaste.client.api.ApiBinding;

public class Namaste extends ApiBinding {

    private static String NAMASTE_API_BASE_URL = "https://namaste-edge.cfapps.io/user";

    public Namaste(String accessToken) {
        super(accessToken);
    }

    public Profile getProfile() {
        return restTemplate.getForObject(NAMASTE_API_BASE_URL + "/profile", Profile.class);
    }

    public Message getMessage() {
        return restTemplate.getForObject(NAMASTE_API_BASE_URL + "/message", Message.class);
    }
}