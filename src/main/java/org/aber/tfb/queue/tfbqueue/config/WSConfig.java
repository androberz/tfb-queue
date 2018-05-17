package org.aber.tfb.queue.tfbqueue.config;

import org.aber.tfb.queue.tfbqueue.services.soap.TimeZoneServiceImpl;
import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.ws.Endpoint;

@Configuration
public class WSConfig {

    @Bean(name = Bus.DEFAULT_BUS_ID)
    public SpringBus springBus() {
        return new SpringBus();
    }

    @Bean
    public Endpoint endpoint() {
        EndpointImpl endpoint = new EndpointImpl(springBus(), new TimeZoneServiceImpl());
        endpoint.publish("/TimeZoneService");

        return endpoint;
    }
}
