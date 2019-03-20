package com.service.ribbon.inter;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.service.ribbon.service.HelloWorldServiceFailure;

@FeignClient(value="${url}",fallback=HelloWorldServiceFailure.class)//@FeignClient注解添加fallback类， 该类必须实现@FeignClient修饰的接口 实现断路器
public interface HelloWorldService {
	/**
	 * @FeignClient用于通知Feign组件对该接口进行代理(不需要编写接口实现)，使用者可直接通过@Autowired注入; 该接口通过value定义了需要调用的ARISGO-EUREKA-CLIENT服务（通过服务中心自动发现机制会定位具体URL）;
	 *  @RequestMapping定义了Feign需要访问的ARISGO-EUREKA-CLIENT服务的URL（本例中为根“/”）
	 * 
	 * Spring Cloud应用在启动时，Feign会扫描标有@FeignClient注解的接口，生成代理，并注册到Spring容器中。生成代理时Feign会为每个接口方法创建一个RequetTemplate对象，
	 * 该对象封装了HTTP请求需要的全部信息，请求参数名、请求方法等信息都是在这个过程中确定的，Feign的模板化就体现在这里
	 */
	@RequestMapping(value = "/",method = RequestMethod.GET)
	String sayHello();
}
