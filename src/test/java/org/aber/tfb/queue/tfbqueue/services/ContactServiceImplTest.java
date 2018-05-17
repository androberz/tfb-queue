package org.aber.tfb.queue.tfbqueue.services;

import org.aber.tfb.queue.tfbqueue.model.Contact;
import org.aber.tfb.queue.tfbqueue.model.TimeZoneResponse;
import org.aber.tfb.queue.tfbqueue.model.WorkItem;
import org.aber.tfb.queue.tfbqueue.repository.WorkItemRepository;
import org.aber.tfb.queue.tfbqueue.services.converter.ContactToTaskConverter;
import org.aber.tfb.queue.tfbqueue.services.soap.TimeZoneService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import static org.mockito.ArgumentMatchers.anyString;

public class ContactServiceImplTest {

    private static final String REGION = "Moscow";

    private ContactServiceImpl contactService;
    @Spy
    private WorkItemRepository workItemRepository;
    @Mock
    private TimeZoneService timeZoneService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        Mockito.when(timeZoneService.getTimeZone(anyString())).thenReturn(new TimeZoneResponse() {{
            setRegion(REGION);
        }});

        contactService = new ContactServiceImpl(new ContactToTaskConverter(), workItemRepository, timeZoneService);
    }

    @Test
    public void testCreateWorkItem() {
        Contact givenContact = getContact();

        WorkItem expectedWorkItem = new WorkItem();
        expectedWorkItem.setFirstName(givenContact.getFirstName());
        expectedWorkItem.setLasName(givenContact.getLastName());
        expectedWorkItem.setPhoneNumber(givenContact.getPhoneNumber());
        expectedWorkItem.setRegion(REGION);

        contactService.createWorkItem(givenContact);

        Mockito.verify(workItemRepository, Mockito.times(1)).save(expectedWorkItem);
    }

    private Contact getContact() {
        Contact contact = new Contact();
        contact.setFirstName("First Name");
        contact.setLastName("Last Name");
        contact.setPhoneNumber("12345678910");

        return contact;
    }
}