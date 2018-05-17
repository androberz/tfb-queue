package org.aber.tfb.queue.tfbqueue.services.amqp;

import org.aber.tfb.queue.tfbqueue.model.Contact;
import org.aber.tfb.queue.tfbqueue.services.ContactService;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = {"taskQueue"})
public class ContactReceiver {

    private final ContactService contactService;

    @Autowired
    public ContactReceiver(ContactService contactService) {
        this.contactService = contactService;
    }

    @RabbitHandler
    public void receiveTask(Contact contact) {
        contactService.createWorkItem(contact);
    }

}
