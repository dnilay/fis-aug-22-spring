package org.example.spring_demo2.config;

import java.util.Scanner;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "org.example.spring_demo2.model")
public class SpringConfig {

	@Bean
	public Scanner scanner() {
		return new Scanner(System.in);
	}
}
