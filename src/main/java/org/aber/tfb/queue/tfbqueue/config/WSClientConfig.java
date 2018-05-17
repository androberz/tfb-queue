package org.aber.tfb.queue.tfbqueue.config;

import org.aber.tfb.queue.tfbqueue.services.soap.TimeZoneService;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WSClientConfig {

    @Bean(name = "wsClient")
    public TimeZoneService generateProxy() {
        return (TimeZoneService) proxyFactoryBean().create();
    }

    @Bean
    public JaxWsProxyFactoryBean proxyFactoryBean() {
        JaxWsProxyFactoryBean proxyFactoryBean = new JaxWsProxyFactoryBean();
        proxyFactoryBean.setServiceClass(TimeZoneService.class);
        proxyFactoryBean.setAddress("http://localhost:8080/ws/TimeZoneService");

        return proxyFactoryBean;
    }
}
