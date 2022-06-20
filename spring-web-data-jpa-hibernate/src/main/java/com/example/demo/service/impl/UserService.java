package com.example.demo.service.impl;


import com.example.demo.model.User;
import java.util.List;

public interface UserService {

    User saveUser(User user);
    List<User> getAllUsers();
    User getUserById(long id);
    User updateUser(User user, long id);
    void deleteUser(long id);
}
