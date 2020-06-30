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
        Set<User> user = new HashSet<>((Collection<User>) uR.getAllUsers());
        return user;
    }
}
