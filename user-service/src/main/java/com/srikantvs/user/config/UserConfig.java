package com.srikantvs.user.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class UserConfig {

	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate;
	}
	
	@Bean
	public CommandLineRunner runner(ApplicationContext context) {
		String[] beanDefNames = context.getBeanDefinitionNames();
		return args->{
			for(String beanDefName: beanDefNames) {
				System.out.println(beanDefName);
			}
		};
	}

}
