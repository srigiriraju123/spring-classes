package com.doj.SpringBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

//As SB 1.2 before 1.2 you have to annotate this file with three annotations 
//such as @EnableAutoConfiguration, @Configuration, @ComponentScan
@SpringBootApplication
public class Application extends SpringBootServletInitializer{

	public static void main(String[] args) {
		//System.setProperty("spring.config.name", "app");
		SpringApplication.run(Application.class, args);
	}
	
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(Application.class);
    }
}