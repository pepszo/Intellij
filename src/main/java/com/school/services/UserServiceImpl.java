package com.school.services;

import com.school.beans.User;
import com.school.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepo uR;

    public List<User> getAllUsers() {
        return new ArrayList<>((Collection<User>) uR.findAll());
    }

    public Set<User> getAllProfs() {
        return uR.getAllProfs();
    }

    public Set<User> getAllStuds() {
        return uR.getAllStuds();
    }


    public User saveUser(User user){
        try{
            user.setPass(user.getPass());
            return uR.save(user);
        }catch (DataIntegrityViolationException e){
            throw new DataIntegrityViolationException("Email already exists");
        }

    }

    public Optional<User> getUserById(int idUser){
        return uR.findById(idUser);
    }

    public User updateUser(User updatedUser, int idUser){
        User oldUser = new User();
        oldUser = uR.findById(idUser).orElse(null);
        oldUser.setRole(updatedUser.getRole());

        try{
            oldUser.setEmail(updatedUser.getEmail());
        }catch (DataIntegrityViolationException e){
            throw new DataIntegrityViolationException("Email already exists");
        }

        oldUser.setFirstName(updatedUser.getFirstName());
        oldUser.setLastName(updatedUser.getLastName());
        oldUser.setPass(updatedUser.getPass());
        return uR.save(oldUser);
    }

    public void deleteUser(int idUser){
        uR.deleteById(idUser);
    }
}
