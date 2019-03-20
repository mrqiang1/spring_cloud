package com.service.ribbon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.service.ribbon.inter.HelloWorldService;
import com.service.ribbon.service.HelloService;

@RestController
public class BaseController {
	@Autowired
	HelloService helloService;
	/**
	 * 使用ribbon + restful 实现负载均衡
	 * http://localhost:8901/
	 */
	@RequestMapping("/")
//	@ResponseBody
	public String getHelloServer() {
		return helloService.getHelloContent();
	}
	/**
	 * 使用Feign实现负载均衡
	 * http://localhost:8901/hello
	 */
	@Autowired HelloWorldService helloWorldFeignService;
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String sayHello(){
        return helloWorldFeignService.sayHello();
    }
}
