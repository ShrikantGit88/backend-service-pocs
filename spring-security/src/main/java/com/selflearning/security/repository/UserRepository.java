package com.selflearning.security.repository;


import com.selflearning.security.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

//@Repository annotation is not required as its taken cared by spring-data-jpa
public interface UserRepository  extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);
}
