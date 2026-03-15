package com.lith.playground.section02.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.function.Consumer;
import java.util.function.Function;

@Configuration
@Slf4j
public class ConsumerConfig {

    @Bean
    public Function<Flux<String>, Mono<Void>> reactiveConsumer() {
        return flux -> flux.doOnNext(msg -> log.info("received: {}", msg)).then();
    }
}
