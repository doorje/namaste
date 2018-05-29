package com.mahen.doorje.namaste.account.api;

import lombok.Value;

@Value
public class NamasteAccountCreatedEvent {

    private String accountId;
    private String email;
    private String password;
}
