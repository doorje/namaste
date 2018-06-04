package com.mahen.doorje.namaste.account.api

import org.axonframework.common.IdentifierFactory
import java.io.Serializable

data class AccountId(val identifier: String = IdentifierFactory.getInstance().generateIdentifier()) : Serializable {

    companion object {
        private const val serialVersionUID = -2521069615900157076L
    }
}

data class TokenId(val identifier: String = IdentifierFactory.getInstance().generateIdentifier()) : Serializable {

    companion object {
        private const val serialVersionUID = -2521069615900157076L
    }
}