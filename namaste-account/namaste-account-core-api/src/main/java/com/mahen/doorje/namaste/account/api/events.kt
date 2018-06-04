package com.mahen.doorje.namaste.account.api

abstract class AccountEvent(open val accountId: AccountId)
abstract class TokenEvent(open val tokenId: TokenId)

data class NamasteAccountCreatedEvent(
        override val accountId: AccountId,
        val email: String,
        val password: String
) : AccountEvent(accountId)

data class AccountVerificationTokenCreatedEvent(
        override val tokenId: TokenId,
        val accountId: AccountId,
        val token: String
) : TokenEvent(tokenId)