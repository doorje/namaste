package com.mahen.doorje.namaste.account.query;

import com.mahen.doorje.namaste.account.api.AccountVerificationTokenCreatedEvent;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NamasteAccountVerificationListener {

    private NamasteAccountVerificationTokenRepository repository;
    private NamasteAccountRepository accountRepository;

    @Autowired
    public NamasteAccountVerificationListener(
            NamasteAccountVerificationTokenRepository repository,
            NamasteAccountRepository accountRepository) {
        this.repository = repository;
        this.accountRepository = accountRepository;
    }

    @EventHandler
    public void on(AccountVerificationTokenCreatedEvent event) {
        repository.save(new NamasteAccountVerificationTokenEntry(
                event.getTokenId().getIdentifier(),
                accountRepository.findByAccountId(event.getAccountId().getIdentifier()).get(),
                event.getToken()
        ));
    }
}
