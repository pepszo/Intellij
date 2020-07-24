package com.school.controllers;

import com.school.beans.User;
import com.school.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(path = "/user")
public class UserController {

    @Autowired
    private UserServiceImpl uSI;

    @GetMapping("/all")
    private List<User> getAllUsers(){
        return uSI.getAllUsers();
    }

    @GetMapping("/profs")
    private Set<User> getAllProfs() { return uSI.getAllProfs(); }

    @GetMapping("/studs")
    private Set<User> getAllStuds() { return uSI.getAllStuds(); }

    @GetMapping("/{id}")
    private Optional<User> getUserById(@PathVariable int id){
        return uSI.getUserById(id);
    }

    @PostMapping("/addUser")
    private User addUser(@RequestBody User user){
        return uSI.saveUser(user);
    }

    @PutMapping("/update/{id}")
    private User updateUser(@RequestBody User updatedUser, @PathVariable int id) {
        return uSI.updateUser(updatedUser, id);
    }

    @DeleteMapping("/delete/{id}")
    private void deleteUserById(@PathVariable int id){
        uSI.deleteUser(id);
    }
}
