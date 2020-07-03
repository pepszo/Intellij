package com.school.services;

import com.school.beans.User;
import com.school.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepo uR;

    public Set<User> getAllUsers() {
        return new HashSet<>((Collection<User>) uR.findAll());
    }

    public Set<User> getAllProfs() {
        return uR.getAllProfs();
    }

    public Set<User> getAllStuds() {
        return uR.getAllStuds();
    }


    public User saveUser(User user){
        return uR.save(user);
    }

    public Optional<User> getUserById(int idUser){
        return uR.findById(idUser);
    }

    public User updateUser(User updatedUser, int idUser){
        User oldUser = new User();
        oldUser = uR.findById(idUser).orElse(null);
        oldUser.setRole(updatedUser.getRole());
        oldUser.setEmail(updatedUser.getEmail());
        oldUser.setFirstName(updatedUser.getFirstName());
        oldUser.setLastName(updatedUser.getLastName());
        oldUser.setPass(updatedUser.getPass());
        return uR.save(oldUser);
    }

    public void deleteUser(int idUser){
        uR.deleteById(idUser);
    }
}
