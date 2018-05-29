package com.mahen.doorje.namaste.client.api.namaste;

import feign.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "namaste-edge")
public interface NamasteRegClient {

    @RequestMapping(method = RequestMethod.POST, value = "/account/create", consumes = "application/json")
    Response createAccount(NamasteAccount account);
}
