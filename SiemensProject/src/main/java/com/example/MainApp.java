package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.swagger2.annotations.EnableSwagger2;
//MainSource for Bootstrapping Application
@ComponentScan(basePackages= {"com.example"})
@SpringBootApplication
//Swagger enabled 8084 ("http://localhost:8084/swagger-ui.html#/my45app45controller")
@EnableSwagger2 
public class MainApp extends SpringBootServletInitializer {
	
	//Generate Jar
	@Override
	protected SpringApplicationBuilder configure (SpringApplicationBuilder application ) {
		return application.sources(MainApp.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(MainApp.class, args);
	}

}
