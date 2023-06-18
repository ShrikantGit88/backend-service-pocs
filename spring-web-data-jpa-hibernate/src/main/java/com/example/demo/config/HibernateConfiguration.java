package com.example.demo.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;
import java.util.Properties;

//@Configuration
//@ConditionalOnProperty(prefix = "abcd", name="ishibernate")
public class HibernateConfiguration {
    @Bean
    public DataSource dataSource() {
        DataSourceBuilder dataSource = DataSourceBuilder.create();
        dataSource.driverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.url("jdbc:mysql://localhost:3306/testdb");
        dataSource.username("root");
        dataSource.password("root");

        return dataSource.build();
    }

    @Bean
    //@Primary
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan("com.example.demo.model");
        //sessionFactory.setHibernateProperties(hibernateProperties());
        return sessionFactory;
    }

    @Bean
    public Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
        //properties.put("hibernate.show_sql", "true");
        //properties.put("hibernate.hbm2ddl.auto", "update");
        return properties;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
        emf.setDataSource(dataSource());
        emf.setPackagesToScan("com.example.demo.model");
        emf.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        emf.setJpaProperties(hibernateProperties());
        //emf.setSessionFactory(sessionFactory().getObject()); // set the sessionFactory property
        return emf;
    }
}
