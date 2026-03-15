package com.lith.playground.section03.producer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Supplier;

@Configuration
@Slf4j
public class ProducerConfig {

    @Bean
    public Supplier<String> producer() {
        AtomicInteger counter = new AtomicInteger(0);
        return () -> {
            String msg = "msg-" + counter.incrementAndGet();
            log.info("produced: {}", msg);
            return msg;
        };
    }
}
