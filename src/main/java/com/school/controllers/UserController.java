package com.school.controllers;

import com.school.beans.Role;
import com.school.beans.User;
import com.school.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
public class UserController {

    @Autowired
    private UserServiceImpl uSI;

    @GetMapping("/users")
    private Set<User> getAllUsers(){
        return uSI.getAllUsers();
    }

    @GetMapping("/users/profs")
    private Set<User> getAllProfs() { return uSI.getAllProfs(); }

    @GetMapping("/users/studs")
    private Set<User> getAllStuds() { return uSI.getAllStuds(); }

    @PostMapping("/register/prof")
    private User addProf(@RequestBody User user) {
        Role role = new Role(1);
        user.setRole(role);
        return uSI.saveUser(user);
    }

    @PostMapping("/register/stud")
    private User addStud(@RequestBody User user) {
        Role role = new Role(2);
        user.setRole(role);
        return uSI.saveUser(user);
    }

}