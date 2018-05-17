package org.aber.tfb.queue.tfbqueue.services;

import org.aber.tfb.queue.tfbqueue.model.Contact;
import org.aber.tfb.queue.tfbqueue.model.TimeZoneResponse;
import org.aber.tfb.queue.tfbqueue.model.WorkItem;
import org.aber.tfb.queue.tfbqueue.repository.WorkItemRepository;
import org.aber.tfb.queue.tfbqueue.services.converter.ContactToTaskConverter;
import org.aber.tfb.queue.tfbqueue.services.soap.TimeZoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class ContactServiceImpl implements ContactService {

    private final ContactToTaskConverter contactToTaskConverter;
    private final WorkItemRepository workItemRepository;
    private final TimeZoneService wsClient;

    @Autowired
    public ContactServiceImpl(ContactToTaskConverter contactToTaskConverter, WorkItemRepository workItemRepository, @Qualifier("wsClient") TimeZoneService wsClient) {
        this.contactToTaskConverter = contactToTaskConverter;
        this.workItemRepository = workItemRepository;
        this.wsClient = wsClient;
    }

    @Override
    public void createWorkItem(Contact contact) {
        TimeZoneResponse timeZoneResponse = wsClient.getTimeZone(contact.getPhoneNumber());

        WorkItem task = contactToTaskConverter.convert(contact);
        task.setRegion(timeZoneResponse.getRegion());

        workItemRepository.save(task);
    }
}
