package com.foalnet.cloudsale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by FYQ on 2017/3/9.
 * 注释部分为需要打war包时配置，springBoot默认是jar包可以直接跑；
 */
@SpringBootApplication
public class CloudSaleApplication {
//打成war包至tomcat是需要此配置，一般使用springBoot内置tomcat，打啥war包呢？
//public class CloudSaleApplication extends SpringBootServletInitializer {
//	@Override
//	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
//		return application.sources(CloudSaleApplication.class);
//	}
	public static void main(String[] args) {
		SpringApplication.run(CloudSaleApplication.class, args);
	}

}
