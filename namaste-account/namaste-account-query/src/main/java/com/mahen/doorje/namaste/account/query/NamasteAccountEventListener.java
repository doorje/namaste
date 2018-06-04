package com.mahen.doorje.namaste.account.query;

import com.mahen.doorje.namaste.account.api.NamasteAccountCreatedEvent;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NamasteAccountEventListener {

    private NamasteAccountRepository repository;

    @Autowired
    public NamasteAccountEventListener(NamasteAccountRepository repository) {
        this.repository = repository;
    }

    @EventHandler
    public void on(NamasteAccountCreatedEvent event) {
        repository.save(new NamasteAccountEntry(
                event.getAccountId().getIdentifier(),
                event.getEmail(),
                event.getPassword()));
    }
}
