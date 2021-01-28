package com.ecommerce.app.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class EcommerceServicioGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcommerceServicioGatewayApplication.class, args);
	}

}
