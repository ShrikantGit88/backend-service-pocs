package com.example.demo;

import com.example.demo.model.User;
import com.example.demo.service.impl.ParentComponent;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
//@PropertySource("classpath:application.properties")
public class SpringWebDataJpaHibernateApplication {
	@Bean
	public ParentComponent parentComponent() {
		ParentComponent parentComponent = new ParentComponent();
		return parentComponent;
	}
	public static void main(String[] args) {
		ApplicationContext ac = SpringApplication.run(SpringWebDataJpaHibernateApplication.class, args);	}

}
