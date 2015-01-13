package com.ofg.clients.config;

import com.ofg.clients.controller.ClientsService;
import com.ofg.infrastructure.web.resttemplate.fluent.ServiceRestClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
class ClientConfiguration {

    @Bean
    ClientsService clientsService(ServiceRestClient serviceRestClient) {
        return new ClientsService(serviceRestClient);
    }

}
