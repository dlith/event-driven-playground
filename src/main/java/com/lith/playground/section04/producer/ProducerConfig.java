package com.lith.playground.section04.producer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

import java.io.BufferedReader;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Supplier;

@Configuration
@Slf4j
public class ProducerConfig implements CommandLineRunner {

    private static final String PINT_OUT = "ping-out";
    private final StreamBridge streamBridge;

    public ProducerConfig(StreamBridge streamBridge) {
        this.streamBridge = streamBridge;
    }


    @Override
    public void run(String... args) throws Exception {
        Process process = new ProcessBuilder("ping", "-n", "10", "google.com")
                .redirectErrorStream(true)
                .start();
        try (BufferedReader reader = process.inputReader()) {
            reader.lines()
                    .forEach(line -> {
                        log.info("sending: {}", line);
                        this.streamBridge.send(PINT_OUT, line);
                    });
        }
    }
}
