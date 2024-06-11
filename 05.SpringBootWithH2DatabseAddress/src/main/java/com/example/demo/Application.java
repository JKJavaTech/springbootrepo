package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
@EnableFeignClients
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	//Configure the RestTemplate for communicating the another service.
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	//Using The WebClient to communicate between two services
	@Bean
	public WebClient webClient() {
		return WebClient.builder().build();
	}
	
}
