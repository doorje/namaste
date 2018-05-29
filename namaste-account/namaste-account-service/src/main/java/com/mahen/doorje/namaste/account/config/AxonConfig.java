package com.mahen.doorje.namaste.account.config;

import com.mahen.doorje.namaste.account.command.NamasteAccount;
import com.mahen.doorje.namaste.account.command.NamasteAccountCommandHandler;
import org.axonframework.commandhandling.SimpleCommandBus;
import org.axonframework.eventhandling.EventBus;
import org.axonframework.messaging.interceptors.BeanValidationInterceptor;
import org.axonframework.spring.config.AxonConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AxonConfig {

    @Autowired
    private AxonConfiguration axonConfiguration;

    @Autowired
    private EventBus eventBus;

    @Bean
    public NamasteAccountCommandHandler accountCommandHandler() {
        return new NamasteAccountCommandHandler(axonConfiguration.repository(NamasteAccount.class), eventBus);
    }

    @Autowired
    public void configure(@Qualifier("localSegment") SimpleCommandBus simpleCommandBus) {
        simpleCommandBus.registerDispatchInterceptor(new BeanValidationInterceptor<>());
    }
}
