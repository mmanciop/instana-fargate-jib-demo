package com.instana.demos.fargatejib;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class GreetingsApp {

	public static void main(String[] args) {
		SpringApplication.run(GreetingsApp.class, args);
	}

	@RestController("/api")
	class Api {

		@GetMapping("greeting")
		public String getGreeting() {
			return "Hello there";
		}

	}

}
