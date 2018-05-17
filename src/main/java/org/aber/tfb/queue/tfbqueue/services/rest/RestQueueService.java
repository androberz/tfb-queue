package org.aber.tfb.queue.tfbqueue.services.rest;

import org.aber.tfb.queue.tfbqueue.model.Contact;
import org.aber.tfb.queue.tfbqueue.services.amqp.ContactSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestQueueService {

    private final ContactSender contactSender;

    @Autowired
    public RestQueueService(ContactSender contactSender) {
        this.contactSender = contactSender;
    }

    @PostMapping(value = "/send/task", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> sendTestTask(@RequestBody Contact aTask) {
        contactSender.sendContact(aTask);

        return ResponseEntity.ok().build();
    }
}
