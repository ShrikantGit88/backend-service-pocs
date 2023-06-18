package com.example.demo.repository;

import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;


public interface UserRepositoryCustom  {
    List<User> findUsersByEmails(Set<String> emails);
}
