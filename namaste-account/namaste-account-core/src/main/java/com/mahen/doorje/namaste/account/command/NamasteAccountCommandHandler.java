package com.mahen.doorje.namaste.account.command;

import org.axonframework.commandhandling.model.Repository;
import org.axonframework.eventhandling.EventBus;

public class NamasteAccountCommandHandler {

    private Repository<NamasteAccount> repository;
    private EventBus eventBus;

    public NamasteAccountCommandHandler(Repository<NamasteAccount> repository, EventBus eventBus) {
        this.repository = repository;
        this.eventBus = eventBus;
    }
}
