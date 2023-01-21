package com.kayo.lab6.controllers;

import com.kayo.lab6.models.User;
import com.kayo.lab6.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<User>> listAll(){
        return ResponseEntity.status(HttpStatus.OK).body(userService.findAllUsers());
    }

    @GetMapping("{id}")
    public User findUserById(@PathVariable Long id) {
        return userService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> addUser(@RequestBody User u) {
        if(u==null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User is null");
        }
        userService.addUser(u);
        return ResponseEntity.status(HttpStatus.OK).body("User is added");
    }


    @DeleteMapping("{id}")
    public ResponseEntity<String>deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return ResponseEntity.status(HttpStatus.OK).body("User deleted");
    }
}
