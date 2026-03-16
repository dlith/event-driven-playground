package com.lith.playground.section05.producer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Supplier;

@Configuration
@Slf4j
public class ReactiveProducerConfig {

    @Bean
    public Supplier<Flux<String>> reactiveProducer() {
        return () -> Flux.interval(Duration.ofMillis(500))
                .map(i -> "msg-" + i)
                .doOnNext(msg -> log.info("sending: {}", msg));
    }
}
