package com.ecommerce.app.productos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
@EntityScan({"com.ecommerce.app.commons.models.productos"})
public class EcommerceServicioProductosApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcommerceServicioProductosApplication.class, args);
	}

}
