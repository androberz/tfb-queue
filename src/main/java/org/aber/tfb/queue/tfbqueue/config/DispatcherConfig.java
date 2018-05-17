package org.aber.tfb.queue.tfbqueue.config;

import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

@Configuration
public class DispatcherConfig {

    private final WebApplicationContext applicationContext;

    @Autowired
    public DispatcherConfig(WebApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Bean
    public ServletRegistrationBean<DispatcherServlet> restServlet() {
        return new ServletRegistrationBean<>(new DispatcherServlet(applicationContext), "/rest/*");
    }

    @Bean
    public ServletRegistrationBean<CXFServlet> dispatcherServlet() {
        return new ServletRegistrationBean<>(new CXFServlet(), "/ws/*");
    }
}
