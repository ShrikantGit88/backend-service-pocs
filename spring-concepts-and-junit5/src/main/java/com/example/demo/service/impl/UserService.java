package com.example.demo.service.impl;


import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.User;
import java.util.List;

public interface UserService {

    User saveUser(User user);
    List<User> getAllUsers();
    User getUserById(long id) throws ResourceNotFoundException;
    User updateUser(User user, long id);
    void deleteUser(long id);
    boolean isEven(int a);
}
