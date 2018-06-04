package com.mahen.doorje.namaste.account.api

import org.axonframework.commandhandling.TargetAggregateIdentifier

abstract class AccountCommand(@TargetAggregateIdentifier open val accountId: AccountId)
abstract class TokenCommand(@TargetAggregateIdentifier open val tokenId:TokenId)

data class CreateNamasteAccountCommand (
        override val accountId: AccountId,
        val email: String,
        val password: String
) : AccountCommand(accountId)

data class CreateAccountVerificationTokenCommand (
        override val tokenId: TokenId,
        val accountId: AccountId,
        val token: String
) : TokenCommand(tokenId)