package com.lith.even_driven_playground;

import com.lith.playground.section01.SectionRunner;
import org.springframework.boot.SpringApplication;

public class TestEvenDrivenPlaygroundApplication {

	public static void main(String[] args) {
		SpringApplication.from(SectionRunner::main).with(TestcontainersConfiguration.class).run(args);
	}

}
