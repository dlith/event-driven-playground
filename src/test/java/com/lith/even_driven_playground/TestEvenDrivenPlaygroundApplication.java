package com.lith.even_driven_playground;

import org.springframework.boot.SpringApplication;

public class TestEvenDrivenPlaygroundApplication {

	public static void main(String[] args) {
		SpringApplication.from(EvenDrivenPlaygroundApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
