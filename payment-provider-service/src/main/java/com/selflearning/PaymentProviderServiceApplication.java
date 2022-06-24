package com.selflearning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class PaymentProviderServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaymentProviderServiceApplication.class, args);
	}

}
