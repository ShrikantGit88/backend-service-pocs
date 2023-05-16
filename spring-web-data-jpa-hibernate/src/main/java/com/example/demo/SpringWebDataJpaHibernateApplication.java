package com.example.demo;

import com.example.demo.model.User;
<<<<<<< Updated upstream
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
=======
import com.example.demo.springlearning.Circle;
import com.example.demo.springlearning.Demo;
import com.example.demo.springlearning.Shape;
import com.example.demo.springlearning.Square;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

@SpringBootApplication
@ConditionalOnClass(Demo.class)
public class SpringWebDataJpaHibernateApplication {
	@Bean("circle")
	@Primary
	public Circle getCircle() {
		return new Circle();
	}
	@Bean
	public Square square() {
		return new Square();
	}
	public static void main(String[] args) {
		SpringApplication.run(SpringWebDataJpaHibernateApplication.class, args);
>>>>>>> Stashed changes
	}
	public static void main(String[] args) {
		ApplicationContext ac = SpringApplication.run(SpringWebDataJpaHibernateApplication.class, args);	}

}
