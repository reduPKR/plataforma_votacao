package com.votacao.urna;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class UrnaApplication {
	public static void main(String[] args) {
		SpringApplication.run(UrnaApplication.class, args);
	}
}
