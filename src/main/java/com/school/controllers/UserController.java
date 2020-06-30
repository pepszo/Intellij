package com.school.controllers;

import com.school.beans.User;
import com.school.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
public class UserController {

    @Autowired
    private UserServiceImpl uSI;

    @GetMapping("/users")
    public Set<User> getAllUsers(){
        return uSI.getAllUsers();
    }
}
