package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.exception.UserModificationException;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
//@Transactional annotation is not required as its taken cared by spring-data-jpa
public class UserServiceImpl implements UserService{

    // setter-based dependency injection is used when bean instance is optional
    // construction-based dependency injection is used when bean instance is mandatory
    private UserRepository userRepository;

    //@Autowired annotation is not required as spring detects userRepository bean with single constructor
    public UserServiceImpl(UserRepository userRepository) {
        super();
        this.userRepository = userRepository;
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(long id) {

//        Optional<User> user= userRepository.findById(id);
//        if(user.isPresent()) {
//            return user.get();
//        } else {
//            return new ResourceNotFoundException("User", "Id", id);
//        }
        return  userRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("User", "Id", id));
    }

    @Override
    public User updateUser(User user, long id) {
        User existingUser =userRepository.findById(id).orElseThrow(() ->
                new UserModificationException("User", id));
        existingUser.setUsername(user.getUsername());
        existingUser.setPassword(user.getPassword());

        userRepository.save(existingUser);
        return existingUser;
    }

    @Override
    public void deleteUser(long id) {
        User existingUser =userRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("User", "Id", id));
        userRepository.deleteById(id);
    }

    @Override
    public boolean isEven(int a) {
        if(a%2 == 0)
            System.out.println(a+" is even ");
        else
            System.out.println(a+" is odd ");
        return a%2 == 0;
    }


}
