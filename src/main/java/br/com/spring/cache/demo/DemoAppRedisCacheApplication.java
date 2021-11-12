package br.com.spring.cache.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class DemoAppRedisCacheApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoAppRedisCacheApplication.class, args);
	}

}
