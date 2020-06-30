package com.school.services;

import com.school.beans.User;
import com.school.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepo uR;

    public Set<User> getAllUsers() {
        return new HashSet<>((Collection<User>) uR.findAll());
    }

    public Set<User> getAllProfs() {
        return new HashSet<>((Collection<User>) uR.getAllProfs());
    }

    public Set<User> getAllStuds() {
        return new HashSet<>((Collection<User>) uR.getAllStuds());
    }

    public User saveUser(User user){ return uR.save(user); }
}
