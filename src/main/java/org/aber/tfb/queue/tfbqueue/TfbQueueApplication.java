package org.aber.tfb.queue.tfbqueue;

import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

@SpringBootApplication
public class TfbQueueApplication /*extends SpringBootServletInitializer*/ {

    public static void main(String[] args) {
        SpringApplication.run(TfbQueueApplication.class, args);
    }

    /*@Override
    public void onStartup(ServletContext servletContext) throws ServletException {

        AnnotationConfigWebApplicationContext webContext = new AnnotationConfigWebApplicationContext();

        ServletRegistration.Dynamic restDispatcher = servletContext.addServlet("Rest dispatcher", new DispatcherServlet(webContext));
        restDispatcher.setLoadOnStartup(1);
        restDispatcher.addMapping("/api/*");

        ServletRegistration.Dynamic cfxDispatcher = servletContext.addServlet("CFX dispathcer", new CXFServlet());
        cfxDispatcher.setLoadOnStartup(2);
        cfxDispatcher.addMapping("/ws/*");

        servletContext.addListener(new ContextLoaderListener());
    }*/
}
