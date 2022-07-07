package com.selflearning.security.controller;

import com.selflearning.security.model.User;
import com.selflearning.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
//this annotation combines @Controller and @ResponseBody annotation which eliminates need to
//annotate every request handling method
@RequestMapping("/users")
public class UserController {
    private UserService userService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public UserController(UserService userService) {
        super();
        this.userService = userService;
    }

    //Create user REST API
    @PostMapping("/join")
    public String joinGroup(@RequestBody  User user) {
        user.setRoles("ROLE_USER");
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword((encodedPassword));
        userService.saveUser(user);
        return "Hi "+user.getUsername()+" welcome to group!";
    };

    @GetMapping("access/{userId}/{userRole}")
    //@Secured("ROLE_ADMIN")
    @PreAuthorize("hasAuthority('ROLE_ADMIN') or hasAuthority('ROLE_MODERATOR')")
    public String checkUserAuthentication(@PathVariable int userId, @PathVariable String userRole,  Principal principal) {
        User user = userService.getUserById(userId);
        return "Hi "+user.getUsername()+" New Role assign to you by "+principal.getName();
    }

    private String getRolesByLoggedInUser(Principal principal) {
        String roles = userService.findByUsername(principal.getName()).getRoles();
        return roles;
    }

    @GetMapping
    @Secured("ROLE_ADMIN")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public List<User> loadAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/test")
    @Secured("ROLE_USER")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public String testUser() {
        return "User can only access this!";
    }

}
