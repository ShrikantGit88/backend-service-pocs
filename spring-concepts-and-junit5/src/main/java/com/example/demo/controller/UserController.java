package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.impl.UserService;
import com.example.demo.springlearning.Shape;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//this annotation combines @Controller and @ResponseBody annotation which eliminates need to
//annotate every request handling method
@RequestMapping("/api/users")
public class UserController {
     private UserService userService;

     @Autowired
     @Qualifier("circle")
     Shape shape;

    public UserController(UserService userService) {
        super();
        this.userService = userService;
    }

    //Create user REST API
    @PostMapping
    public ResponseEntity<User> saveUser(@RequestBody  User user) {
        return new ResponseEntity<User>(userService.saveUser(user), HttpStatus.CREATED);
    };

    //get all users REST API
    @GetMapping
    public List<User> getAllUsers() {
        System.out.println("Inside getAllUsers");
        System.out.println(Runtime.getRuntime().availableProcessors());
        shape.draw();
        return userService.getAllUsers();
    }

    //get user by ID REST API using url template variable
    //http://localhost:8080/api/users/1
    @GetMapping("{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") long userId) {
        return new ResponseEntity<User>(userService.getUserById(userId), HttpStatus.OK);
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
}
