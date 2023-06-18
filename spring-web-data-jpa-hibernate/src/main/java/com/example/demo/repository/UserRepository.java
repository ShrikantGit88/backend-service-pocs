package com.example.demo.repository;

import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

//@Repository annotation is not required as its taken cared by spring-data-jpa
public interface UserRepository  extends JpaRepository<User, Long>, UserRepositoryCustom {
//    @Transactional
//    User save(User user);
}
