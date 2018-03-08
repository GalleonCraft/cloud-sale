package com.foalnet.cloudsale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class CloudSaleApplication {
//打包至tomcat是需要此配置，开发时屏蔽
//public class CloudSaleApplication extends SpringBootServletInitializer {
//	@Override
//	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
//		return application.sources(CloudSaleApplication.class);
//	}
	public static void main(String[] args) {
		SpringApplication.run(CloudSaleApplication.class, args);
	}
}
