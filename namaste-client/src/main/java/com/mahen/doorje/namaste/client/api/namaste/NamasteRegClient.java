package com.mahen.doorje.namaste.client.api.namaste;

import com.mahen.doorje.namaste.client.web.dto.NamasteAccountDto;
import feign.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "namaste-edge")
public interface NamasteRegClient {

    @RequestMapping(method = RequestMethod.POST, value = "/account/create", consumes = "application/json")
    Response createAccount(NamasteAccountDto account);

    @RequestMapping(method = RequestMethod.GET, value = "/account/exists/{email}")
    Response emailExists(@PathVariable("email") String email);
}
