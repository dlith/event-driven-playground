package com.lith.playground.section03.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;

import java.util.function.Consumer;

@Configuration
@Slf4j
public class ConsumerConfig {

    @Bean
    public Consumer<String> consumer() {
        return msg -> log.info("received: {}", msg);
    }

    @Bean
    public Consumer<Message<String>> messageConsumer() {
        return this::handleMessage;
    }

    private void handleMessage(Message<String> message) {
        log.info("message: {}", message);
        Object key = message.getHeaders().get(KafkaHeaders.RECEIVED_KEY);
        Object payload = message.getPayload();
        log.info("key: {}, payload: {}", key, payload);
    }
}
