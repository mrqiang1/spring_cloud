package com.service.ribbon.service;

import org.springframework.stereotype.Component;

import com.service.ribbon.inter.HelloWorldService;
@Component
public class HelloWorldServiceFailure implements HelloWorldService {

	@Override
	public String sayHello() {
		// TODO Auto-generated method stub
		System.out.println("hello world service is not available !");
        return "hello world service is not available !";
	}

}
