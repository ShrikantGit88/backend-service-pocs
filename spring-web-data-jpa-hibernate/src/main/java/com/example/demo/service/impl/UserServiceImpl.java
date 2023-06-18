package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.exception.UserModificationException;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

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

    @Autowired
    SessionFactory sessionFactory;

    public void hibernateTest(){

        System.out.println("sessionFactory().getObject() "+sessionFactory.toString());
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        User user = new User();
        user.setId(11l);
        user.setEmail("shri@gmail.com");
        //User user1 = session.load(User.class, 11l);

//        session.evict(user1);
//        user1 = session.load(User.class, 11l);
//
//        session.update(user1);
//        user.setUsername("new2");
//        session.persist(user);
        session.getTransaction().commit();
        System.out.println(" >>>"+user.getId());
        session.close();
    }
    @Override
    @Transactional
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
        existingUser.setEmail(user.getEmail());

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
    public List<User> findUsersByEmails(Set<String> emails) {
        return userRepository.findUsersByEmails(emails);
    }
}
