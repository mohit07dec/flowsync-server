package com.flowsync.FlowSyncApp.controller;

import com.flowsync.FlowSyncApp.entity.User;
import com.flowsync.FlowSyncApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAll() {
        return userService.getAll();
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User newUser) {
        try {
            userService.saveEntry(newUser);
            return new ResponseEntity<>(newUser, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping
    public ResponseEntity<User> updateUserById(@RequestBody User user) {
        User updatedUser = userService.findByUserName(user.getUserName());
        if(updatedUser != null){
            updatedUser.setUserName(user.getUserName() != null && !user.getUserName().equals("") ? user.getUserName() : updatedUser.getUserName());
            updatedUser.setPassword(user.getPassword() != null && !user.getPassword().equals("") ? user.getPassword() : updatedUser.getPassword());
            userService.saveEntry(updatedUser);
            return new ResponseEntity<>(updatedUser, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
