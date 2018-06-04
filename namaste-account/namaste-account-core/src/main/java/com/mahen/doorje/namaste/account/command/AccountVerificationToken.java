package com.mahen.doorje.namaste.account.command;

import com.mahen.doorje.namaste.account.api.AccountId;
import com.mahen.doorje.namaste.account.api.AccountVerificationTokenCreatedEvent;
import com.mahen.doorje.namaste.account.api.CreateAccountVerificationTokenCommand;
import com.mahen.doorje.namaste.account.api.TokenId;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.commandhandling.model.AggregateIdentifier;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.spring.stereotype.Aggregate;

import static org.axonframework.commandhandling.model.AggregateLifecycle.apply;

@Aggregate
public class AccountVerificationToken {

    @AggregateIdentifier
    private TokenId tokenId;

    private AccountId accountId;
    private String token;

    @SuppressWarnings("unused")
    public AccountVerificationToken() {}

    @CommandHandler
    public AccountVerificationToken(CreateAccountVerificationTokenCommand command) {
        apply(new AccountVerificationTokenCreatedEvent(
                command.getTokenId(),
                command.getAccountId(),
                command.getToken()
        ));
    }

    @EventSourcingHandler
    public void on(AccountVerificationTokenCreatedEvent event) {
        this.tokenId = event.getTokenId();
        this.accountId = event.getAccountId();
        this.token = event.getToken();
    }
}
