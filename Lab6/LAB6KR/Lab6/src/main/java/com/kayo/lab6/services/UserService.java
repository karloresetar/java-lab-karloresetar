package com.kayo.lab6.services;


import com.kayo.lab6.models.User;
import com.kayo.lab6.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService {
    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository u) {
        userRepository=u;
    }
    public List<User> findAllUsers(){return userRepository.getAll();
    }
    public User getById(Long id) {
        return userRepository.getById(id);
    }
    public void addUser(User u) {
        userRepository.add(u);
    }
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
