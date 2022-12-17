package com.example.docker.controller;

import com.example.docker.entities.User;
import com.example.docker.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/getUser")
    public List<User> findAll(){
        return userService.findAll();
    }

    @PostMapping("/addUser")
    public User add(@RequestBody User user){
        return userService.add(user);
    }
}
