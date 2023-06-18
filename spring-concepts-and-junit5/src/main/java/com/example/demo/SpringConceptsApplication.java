package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringConceptsApplication {

	public static void main(String[] args) throws InterruptedException {
		ApplicationContext applicationContext = SpringApplication.run(SpringConceptsApplication.class, args);
//		for(String beanName : applicationContext.getBeanDefinitionNames()){
//			System.out.println("### "+beanName);
//		}


	}

}
