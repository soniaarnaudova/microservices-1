package com.microservices.users.controllers;

import com.microservices.users.entities.User;
import com.microservices.users.services.UserService;
import com.microservices.users.vo.ResponseTemplateVO;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@Log
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/add")
    public User addUser(@RequestBody User user){
        log.info("Add user....");
        return userService.addUser(user);
    }

    @GetMapping("/all")
    public List<User> getAllUsers(){
        log.info("Get all users....");
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public ResponseTemplateVO getUserWithDepartment(@PathVariable("id") Long id) {
        log.info("getUserWithDepartment");
        return userService.getUserWithDepartment(id);
    }
}

