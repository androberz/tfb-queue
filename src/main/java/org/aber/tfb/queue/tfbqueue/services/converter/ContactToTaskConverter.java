package org.aber.tfb.queue.tfbqueue.services.converter;

import com.google.i18n.phonenumbers.PhoneNumberToTimeZonesMapper;
import com.google.i18n.phonenumbers.Phonenumber;
import org.aber.tfb.queue.tfbqueue.model.Contact;
import org.aber.tfb.queue.tfbqueue.model.WorkItem;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ContactToTaskConverter implements Converter<Contact, WorkItem> {

    @Override
    public WorkItem convert(Contact contact) {
        WorkItem workItem = new WorkItem();

        workItem.setFirstName(contact.getFirstName());
        workItem.setLasName(contact.getLastName());
        workItem.setMiddleName(contact.getMiddleName());
        workItem.setPhoneNumber(contact.getPhoneNumber());

        Phonenumber.PhoneNumber phoneNumber = new Phonenumber.PhoneNumber();
        phoneNumber.setRawInput(contact.getPhoneNumber());
        List<String> timeZonesForNumber = PhoneNumberToTimeZonesMapper.getInstance().getTimeZonesForNumber(phoneNumber);

        return workItem;
    }
}
