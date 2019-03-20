package com.service.ribbon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class HelloService {
	@Autowired
	RestTemplate restTemplate;
	
	@Value("${url}")
	private String url;
	@HystrixCommand(fallbackMethod="serviceFailure")//为当前指定fallbackMethod方法  
	/**
	 * @HystrixCommand注解定义了一个断路器，它封装了getHelloContant()方法， 当它访问的SERVICE-HELLOWORLD失败达到阀值后，将不会再调用SERVICE-HELLOWORLD
	 * 取而代之的是返回由fallbackMethod定义的方法serviceFailure（）。@HystrixCommand注解定义的fallbackMethod方法，需要特别注意的有两点：
	 * 第一，  fallbackMethod的返回值和参数类型需要和被@HystrixCommand注解的方法完全一致。否则会在运行时抛出异常。比如本例中，serviceFailure（）的返回值和getHelloContant()方法的返回值都是String。
	 * 
	 * 第二，  当底层服务失败后，fallbackMethod替换的不是整个被@HystrixCommand注解的方法（本例中的getHelloContant), 替换的只是通过restTemplate去访问的具体服务。可以从中的system输出看到， 
	 * 即使失败，控制台输出里面依然会有“call SERVICE-HELLOWORLD”
	 * 
	 */
	public String getHelloContent() {
		//这里的URL是注册到eureka中Hello world服务的名字，而注册到服务中心的有两个ARISGO-EUREKA-CLIENT。 
		//所以，这个调用本质是ribbon-service作为客户端根据负载均衡算法自主选择了一个作为服务端的ARISGO-EUREKA-CLIENT服务。然后再访问选中的ARISGO-EUREKA-CLIENT来执行真正的Hello world调用
		String uri = restTemplate.getForObject(url, String.class);
		return uri;
	}
	/**
	 * Ribbon+restful 以这种方式实现短路器
	 * 
	 */
	public String serviceFailure() {
		System.out.println("当前服务器状态不可用！ hello world service is not available !");
		return "当前服务器状态不可用！ hello world service is not available !";
	}
}
