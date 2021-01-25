package com.ecommerce.app.facturas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
//import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableEurekaClient
//@EnableFeignClients
@SpringBootApplication
//@EntityScan( { "com.ecommerce.app.commons.entity" })
public class EcommerceServicioFacturasApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcommerceServicioFacturasApplication.class, args);
	}

}
