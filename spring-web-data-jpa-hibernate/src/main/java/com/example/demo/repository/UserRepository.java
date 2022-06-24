package com.example.demo.repository;

import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

//@Repository annotation is not required as its taken cared by spring-data-jpa
public interface UserRepository  extends JpaRepository<User, Long> {
}
