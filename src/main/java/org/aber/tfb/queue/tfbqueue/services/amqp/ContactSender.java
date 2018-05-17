package org.aber.tfb.queue.tfbqueue.services.amqp;

import org.aber.tfb.queue.tfbqueue.model.Contact;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ContactSender {

    private final RabbitTemplate rabbitTemplate;
    private final Queue taskQueue;

    @Autowired
    public ContactSender(RabbitTemplate rabbitTemplate, Queue taskQueue) {
        this.rabbitTemplate = rabbitTemplate;
        this.taskQueue = taskQueue;
    }

    public void sendContact(Contact contact) {
        rabbitTemplate.convertAndSend(taskQueue.getName(), contact);
    }
}
