package com.mahen.doorje.namaste.account.command;

import com.mahen.doorje.namaste.account.api.NamasteAccountCreatedEvent;
import com.mahen.doorje.namaste.account.api.CreateNamasteAccountCommand;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.commandhandling.model.AggregateIdentifier;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.spring.stereotype.Aggregate;

import static org.axonframework.commandhandling.model.AggregateLifecycle.apply;

@Aggregate
public class NamasteAccount {

    @AggregateIdentifier
    private String accountId;
    private String email;
    private String password;

    @SuppressWarnings("unused")
    private NamasteAccount() {
    }

    @CommandHandler
    public NamasteAccount(CreateNamasteAccountCommand command) {
        apply(new NamasteAccountCreatedEvent(
                command.getAccountId(),
                command.getEmail(),
                command.getPassword()));
    }

    @EventSourcingHandler
    public void on(NamasteAccountCreatedEvent event) {
        this.accountId = event.getAccountId();
        this.email = event.getEmail();
        this.password = event.getPassword();
    }
}
