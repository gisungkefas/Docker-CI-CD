package com.example.docker.services;

import com.example.docker.entities.User;
import com.example.docker.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UsersRepository usersRepository;

    public List<User> findAll(){
        return usersRepository.findAll();
    }

    public User add(User user) {
        return usersRepository.saveAndFlush(user);
    }
}
