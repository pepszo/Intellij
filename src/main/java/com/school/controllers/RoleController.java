package com.school.controllers;

import com.school.beans.Role;
import com.school.services.RoleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(path = "/role")
public class RoleController {

    @Autowired
    private RoleServiceImpl rSI;

    @GetMapping("/{id}")
    private Optional<Role> getUserById(@PathVariable int id){
        return rSI.getRoleById(id);
    }
}
