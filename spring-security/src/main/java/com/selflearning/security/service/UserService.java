package com.selflearning.security.service;



import com.selflearning.security.model.User;

import java.security.Principal;
import java.util.List;

public interface UserService {

    User saveUser(User user);
    List<User> getAllUsers();
    User getUserById(long id);
    User findByUsername(String name);
    User updateUser(User user, long id);
    void deleteUser(long id);
}
