package com.mahen.doorje.namaste.client;

import com.mahen.doorje.namaste.client.api.namaste.NamasteToken;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.beans.factory.annotation.Autowired;

public class NamasteRequectInterceptor implements RequestInterceptor {

    private static final String AUTHORIZATION_HEADER = "Authorization";
    private static final String BEARER_TOKEN_TYPE = "Bearer";

    @Autowired
    private NamasteToken accessToken;

    @Override
    public void apply(RequestTemplate template) {
        if (accessToken != null) {
            template.header(AUTHORIZATION_HEADER, String.format("%s %s", BEARER_TOKEN_TYPE, accessToken.getToken()));
        }
    }
}
