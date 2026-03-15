package com.lith.playground.section02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SectionRunner {

    public static void main(String[] args) {
        SpringApplication.run(
                SectionRunner.class,
                "--section=section02",
                "--config=01-reactive-consumer"
        );
    }

}
