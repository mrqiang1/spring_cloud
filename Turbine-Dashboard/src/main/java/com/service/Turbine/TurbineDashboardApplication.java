package com.service.Turbine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

@SpringBootApplication
@EnableHystrixDashboard
@EnableTurbine
//用@EnableHystrixDashboard和@EnableTurbine修饰主类， 分别用于支持Hystrix Dashboard和Turbine
/**
 * 
 * @author wangwq20
 * 对整个系统的短路器监控Turbine
 *通过Turbine服务访问HystrixDashborad， http:localhost:8903/hystrix
 * 监控流的URL填http://localhost:8903/turbine.stream, 点击monitor stream, 进入监控页面
 */
public class TurbineDashboardApplication {

	public static void main(String[] args) {
		SpringApplication.run(TurbineDashboardApplication.class, args);
	}

}
