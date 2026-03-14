package com.lith.playground.section01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SectionRunner {

    public static void main(String[] args) {
        SpringApplication.run(
                SectionRunner.class,
                "--section=section01",
                "--config=02-from-beginning"
        );
    }

}
