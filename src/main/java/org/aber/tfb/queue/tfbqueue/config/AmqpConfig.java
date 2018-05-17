package org.aber.tfb.queue.tfbqueue.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AmqpConfig {

    @Bean
    public Queue taskQueue() {
        return new Queue("taskQueue", true, false, false);
    }
}
