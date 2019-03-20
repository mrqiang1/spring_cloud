package com.eureka.config.server;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableEurekaServer
@SpringBootApplication
@EnableConfigServer
@RestController
@RefreshScope
public class SpringCloudConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudConfigServerApplication.class, args);
	}
//	@Value("${configfile}")
//	private String configfile;
//	@RequestMapping(value="getConfig")
//	public String getConfig() {
//		System.out.println("配置服务器读取远程配置文件");
//		return "读取git远程配置文件 服务器端:"+ configfile;
//	}
}

