package com.eureka.config.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RefreshScope
/**
 * 
 * @author wangwq20
 *自动刷新只能刷新 @RefreshScope 注解下的配置，一些特殊配置，如数据库等，需要同样先设置数据库链接ConfigServer类，然后通过加 @RefreshScope 注解方式
 *自动刷新在GitHub上配置Webhooks http://10.112.29.85:8881/actuator/bus-refresh
 */
public class SpringCloudConfigClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudConfigClientApplication.class, args);
	}
	
	@Value("${hello}")
	String hello;
	
	@RequestMapping(value="/hello")
	public String hello() {
		System.out.println("这是spring cloud config client......");
		return "hello Spring cloud:"+hello;
	}
	
	@RequestMapping("/hi")
	public String hi() {
		System.out.println("这是spring cloud config client......:test");
		return "hi wwq";
	}
}

