package com.eureka.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class EurekaClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaClientApplication.class, args);
	}
	@Value("${server.port}")
	String port;
	@RequestMapping(value="/")
	public String home() {
		System.out.println("欢迎访问Spring cloud home  端口:"+port);
		return "欢迎访问Spring cloud home  端口:"+port;
	}
}

