package org.aber.tfb.queue.tfbqueue.services.soap;

import com.google.i18n.phonenumbers.PhoneNumberToTimeZonesMapper;
import com.google.i18n.phonenumbers.Phonenumber;
import org.aber.tfb.queue.tfbqueue.model.TimeZoneResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TimeZoneServiceImpl implements TimeZoneService {

    @Override
    /*
    * It's a stub logic and won't be working correctly, due to lack of phone numbers parsing logic
    * */
    public TimeZoneResponse getTimeZone(String phoneNumber) {
        TimeZoneResponse timeZoneResponse = new TimeZoneResponse();

        String countryCode = phoneNumber.substring(0, 1);
        String phoneDigits = phoneNumber.substring(1, phoneNumber.length());

        Phonenumber.PhoneNumber phNumber = new Phonenumber.PhoneNumber();
        phNumber.setCountryCode(Integer.valueOf(countryCode));
        phNumber.setNationalNumber(Long.parseLong(phoneDigits));
        List<String> timeZonesForNumber = PhoneNumberToTimeZonesMapper.getInstance().getTimeZonesForNumber(phNumber);

        timeZoneResponse.setRegion(timeZonesForNumber.stream().findFirst().orElse("Unknown region"));

        return timeZoneResponse;
    }
}
