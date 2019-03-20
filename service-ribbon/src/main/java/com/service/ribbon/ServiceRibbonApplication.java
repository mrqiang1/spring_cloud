package com.service.ribbon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * Ribbon 是客户端负载均衡器
 * @author wangwq20
 *Spring 提供两辆种服务调度方式：Ribbon+restful和Feign。Ribbon就是一个基于客户端的负载均衡器， Ribbon提供了很多在HTTP和TCP客户端之上的控制. 
 *Feign内部也已经使用了Ribbon, 使用了@FeignClient注解也可以实现
 */
@SpringBootApplication
@EnableDiscoveryClient //向服务中心注册，并且注册了一个叫restTemplate的bean。 开启服务自动发现
@EnableFeignClients //使用Feign进行服务的负载均衡
@EnableCircuitBreaker//Hystrix断路器
/**
 * 
 * 断路器数据监控
 *在Spring Boot启动类上用@EnableHystrixDashboard注解和@EnableCircuitBreaker注解。需要特别注意的是我们之前的Feign服务由于内置断路器支持，
 * 所以没有@EnableHystrixDashboard注解，但要使用Dashboard则必须加，如果不加，Dashboard无法接收到来自Feign内部断路器的监控数据，会报“Unable to connect to Command Metric Stream”错误
 *
 *注：这种方式有个弊端 只能监控一个服务
 *http://localhost:8901/hystrix
 *http://localhost:8901/actuator/hystrix.stream 
 *
 */
@EnableHystrixDashboard
public class ServiceRibbonApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceRibbonApplication.class, args);
	}
	@Bean
	//@ LoadBalanced注册表明，这个restRemplate是需要做负载均衡的。 Ribbon+restful
	@LoadBalanced
	RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
