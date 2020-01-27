package com.eureka.client.service.galleryservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
public class GalleryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GalleryServiceApplication.class, args);
	}

	@Configuration
	class RestTemplateConfig{

		@Bean
		@Scope("singleton") //by default scope is also singleton
		@LoadBalanced // Load balance between service instances running at different ports.
		public RestTemplate restTemplate(){
			return new RestTemplate();
		}
	}

}
