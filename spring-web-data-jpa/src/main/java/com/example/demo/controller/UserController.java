package com.example.demo.controller;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.User;
import com.example.demo.service.impl.UserService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@RestController
//this annotation combines @Controller and @ResponseBody annotation which eliminates need to
//annotate every request handling method
@RequestMapping("/api/users")
public class UserController {
     private final UserService userService;

    public UserController(UserService userService) {
        super();
        this.userService = userService;
    }

    //Create user REST API
    @PostMapping
    public ResponseEntity<User> saveUser(@RequestBody  User user) {
        System.out.println("inside post method "+user.toString());
        return new ResponseEntity<User>(userService.saveUser(user), HttpStatus.OK);
    }

    //get all users REST API
    //http://localhost:8080/api/users
    @GetMapping
    public List<User> getAllUsers() {
        System.out.println("Inside getAllUsers... "+ LocalDateTime.now());
        return userService.getAllUsers();
    }

    //http://localhost:8080/api/users
    @GetMapping("test")
    public String testHibernate() {
        System.out.println("Inside testHibernate... "+ LocalDateTime.now());
        return "OK";
    }
    //get user by ID REST API using url template variable
    //http://localhost:8080/api/users/2
    @GetMapping("{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") long userId) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Custom-Header","foo");
        headers.add("xyz","abc");
        return new ResponseEntity<>(userService.getUserById(userId), headers, HttpStatus.ACCEPTED);
    }

    //get user by ID REST API using url template variable
    //http://localhost:8080/api/users/fetch?userId=2
    @GetMapping("/fetch")
    public User getUserByIdParam(@RequestParam Long userId) {
        User user = userService.getUserById(userId);
        if(Objects.isNull(user)){
            throw new ResourceNotFoundException("Users not found **", "demo","demo");
        }
        return user;
    }

    //update user by Id REST API
    // @RequestBody  annotation is used to convert json in request body to java object
    @PutMapping("{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") long userId, @RequestBody User user ) {
        return new ResponseEntity<User>(userService.updateUser(user, userId), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable("id") long userId) {
        userService.deleteUser(userId);
        return new ResponseEntity<String>("User has been deleted successfully", HttpStatus.OK);
    }

    //http://localhost:8080/api/users
    @GetMapping("byemails")
    public List<User> findUsersByEmails() {
        Set<String> emailids = new HashSet<>();
        emailids.add("abcd@gmail.com");
        emailids.add("xyz@gmail.com");
        System.out.println("Inside findUsersByEmails... "+emailids);
        return userService.findUsersByEmails(emailids);
    }
}
