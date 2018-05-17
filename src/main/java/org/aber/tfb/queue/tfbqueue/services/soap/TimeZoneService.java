package org.aber.tfb.queue.tfbqueue.services.soap;

import org.aber.tfb.queue.tfbqueue.model.TimeZoneResponse;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService(name = "TimeZoneService")
public interface TimeZoneService {

    @WebMethod
    @WebResult(name = "TimeZoneResponse")
    TimeZoneResponse getTimeZone(@WebParam(name = "PhoneNumber") String phoneNumber);
}
