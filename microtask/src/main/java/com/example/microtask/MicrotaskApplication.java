package com.example.microtask;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MicrotaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicrotaskApplication.class, args);
	}

}
