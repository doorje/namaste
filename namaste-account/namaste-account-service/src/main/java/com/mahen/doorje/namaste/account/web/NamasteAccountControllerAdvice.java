package com.mahen.doorje.namaste.account.web;

import org.springframework.hateoas.VndErrors;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class NamasteAccountControllerAdvice {
    @ResponseBody
    @ExceptionHandler(NamasteAccountNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    VndErrors accountNotFoundExceptionHandler(NamasteAccountNotFoundException ex) {
        return new VndErrors("error", ex.getMessage());
    }
}
