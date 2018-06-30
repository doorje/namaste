package com.mahen.doorje.namaste.account.command;

import com.mahen.doorje.namaste.account.api.AccountVerificationTokenCreatedEvent;
import com.mahen.doorje.namaste.account.api.CreateAccountVerificationTokenCommand;
import com.mahen.doorje.namaste.account.api.NamasteAccountCreatedEvent;
import com.mahen.doorje.namaste.account.api.TokenId;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@ProcessingGroup("commandPublishingEventHandlers")
public class AccountVerificationListener {

    private final CommandGateway commandGateway;

    public AccountVerificationListener(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    @EventHandler
    public void on(NamasteAccountCreatedEvent event) {
        TokenId tokenId = new TokenId();
        String token = UUID.randomUUID().toString();
        commandGateway.send(new CreateAccountVerificationTokenCommand(tokenId, event.getAccountId(), token));
    }

    @EventHandler
    public void on(AccountVerificationTokenCreatedEvent event) {

    }
}
