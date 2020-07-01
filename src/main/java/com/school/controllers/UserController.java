package com.school.controllers;

import com.school.beans.User;
import com.school.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping(path = "/user")
public class UserController {

    @Autowired
    private UserServiceImpl uSI;

    @GetMapping("/all")
    private Set<User> getAllUsers(){
        return uSI.getAllUsers();
    }

    @GetMapping("/profs")
    private Set<User> getAllProfs() { return uSI.getAllProfs(); }

    @GetMapping("/studs")
    private Set<User> getAllStuds() { return uSI.getAllStuds(); }

    @PostMapping("/addUser")
    private User addUser(@RequestBody User user){
        return uSI.saveUser(user);
    }

}