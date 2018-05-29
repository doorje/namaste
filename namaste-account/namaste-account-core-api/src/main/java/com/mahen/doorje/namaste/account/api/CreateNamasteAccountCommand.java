package com.mahen.doorje.namaste.account.api;

import lombok.Value;
import org.axonframework.commandhandling.TargetAggregateIdentifier;

@Value
public class CreateNamasteAccountCommand {

    @TargetAggregateIdentifier
    private String accountId;
    private String email;
    private String password;
}
