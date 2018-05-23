package com.mahen.doorje.namaste.client.api.namaste;

import com.mahen.doorje.namaste.client.NamasteRequectInterceptor;
import com.mahen.doorje.namaste.client.api.namaste.user.Message;
import com.mahen.doorje.namaste.client.api.namaste.user.Profile;
import feign.RequestInterceptor;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "namaste-edge", configuration = NamasteClient.NamasteConfiguration.class)
public interface NamasteClient {

    @RequestMapping(method = RequestMethod.GET, value = "/user/profile")
    Profile getProfile();

    @RequestMapping(method = RequestMethod.GET, value = "/user/message")
    Message getMessage();

    class NamasteConfiguration {
        @Bean
        RequestInterceptor requestInterceptor() {
            return new NamasteRequectInterceptor();
        }
    }
}
