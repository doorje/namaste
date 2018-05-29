package com.mahen.doorje.namaste.account.web;

@SuppressWarnings("serial")
public class NamasteAccountNotFoundException extends RuntimeException {
    public NamasteAccountNotFoundException(String accountId) {
        super("could not find account '" + accountId + "'.");
    }
}
