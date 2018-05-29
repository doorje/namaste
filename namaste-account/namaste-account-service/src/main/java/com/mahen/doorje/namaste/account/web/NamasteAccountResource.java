package com.mahen.doorje.namaste.account.web;

import com.mahen.doorje.namaste.account.query.NamasteAccountEntry;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.hateoas.core.Relation;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

public class NamasteAccountResource extends ResourceSupport {

    private final String accountId;
    private final String email;

    public NamasteAccountResource(NamasteAccountEntry accountEntry) {
        this.accountId = accountEntry.getAccountId();
        this.email = accountEntry.getEmail();

        this.add(linkTo(methodOn(NamasteAccountRestController.class).getAccount(accountEntry.getAccountId())).withSelfRel());
    }

    public String getAccountId() {
        return accountId;
    }

    public String getEmail() {
        return email;
    }
}
