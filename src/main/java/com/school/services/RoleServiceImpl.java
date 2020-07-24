package com.school.services;

import com.school.beans.Role;
import com.school.repositories.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService{

    @Autowired
    private RoleRepo rR;

    public Optional<Role> getRoleById(int idRole) {
        return rR.findById(idRole);
    }
}
