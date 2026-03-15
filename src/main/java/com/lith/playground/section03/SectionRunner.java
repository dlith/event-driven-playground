package com.lith.playground.section03;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

public class SectionRunner {

    @SpringBootApplication(scanBasePackages = "com.lith.playground.${section}.consumer")
    static class Consumer {
        public static void main(String[] args) {
            SpringApplication.run(
                    Consumer.class, "--section=section03", "--config=03-message-consumer"
            );
        }

    }

    @SpringBootApplication(scanBasePackages = "com.lith.playground.${section}.producer")
    static class Producer {
        public static void main(String[] args) {
            SpringApplication.run(
                    Producer.class, "--section=section03", "--config=04-message-producer"
            );
        }
    }
}
