package com.ofg.clients.controller

import com.github.fakemongo.Fongo
import com.mongodb.BasicDBObject
import com.mongodb.DB
import com.mongodb.DBCollection
import com.ofg.clients.model.Client
import com.ofg.infrastructure.web.resttemplate.fluent.ServiceRestClient
import com.wordnik.swagger.annotations.Api
import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

import static com.ofg.clients.config.Collaborators.REPORTING_SERVICE
import static com.ofg.clients.config.Collaborators.REPORTING_SERVICE_URL

@Slf4j
@RestController
@RequestMapping('/api')
@Api(value = "client", description = "Operations on clients")
class ClientsService {

    @Autowired
    private ServiceRestClient serviceRestClient

    Fongo fongo

    DB db

    DBCollection collection

    public ClientsService() {
        fongo = new Fongo("ClientsService mongo server")
        db = fongo.getDB("ClientsServiceDb")
        collection = db.getCollection("clients")
    }

    @RequestMapping(value = "/client", method = RequestMethod.POST)
    void retrieveClient(@ModelAttribute Client client) {
        def clientObject = new BasicDBObject('firstName', client.firstName)
            .append('lastName', client.lastName)
            .append('age', client.age)
            .append('loanId', client.loanId)
        collection.insert(clientObject)

        serviceRestClient.forService(REPORTING_SERVICE)
            .post()
            .onUrl(REPORTING_SERVICE_URL)
            .body(client)
            .anObject()
            .ofType(Client)
    }

}
