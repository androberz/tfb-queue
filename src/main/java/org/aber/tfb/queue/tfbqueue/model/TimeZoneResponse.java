package org.aber.tfb.queue.tfbqueue.model;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "TimeZoneResponse")
@Data
public class TimeZoneResponse {

    private String region;

}
