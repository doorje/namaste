package com.mahen.doorje.namaste.client.api.namaste;

import com.mahen.doorje.namaste.client.web.dto.NamasteAccountDto;
import feign.RequestInterceptor;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "namaste-edge", configuration = NamasteClient.NamasteConfiguration.class)
public interface NamasteClient {

    @RequestMapping(method = RequestMethod.GET, value = "/account/{accountId}")
    NamasteAccountDto getAccount(@PathVariable("accountId") String accountId);

    class NamasteConfiguration {
        @Bean
        RequestInterceptor requestInterceptor() {
            return new NamasteRequestInterceptor();
        }
    }
}
